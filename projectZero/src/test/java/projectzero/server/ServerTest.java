package projectzero.server;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import projectzero.exceptions.JoinException;
import projectzero.model.AppResponse;
import projectzero.model.Role;
import projectzero.model.User;
import projectzero.utils.JSONUtils;
import projectzero.utils.LogUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;

public class ServerTest {

    public static final int PORT = 9817;
    private static Server server;
    private static File ordersTestFile;
    private static File usersTestFile;
    private static User user;

    @BeforeClass
    public static void setUp() throws Exception {
        user = new User("An@an.com", "1234", Role.ADMIN);

        ordersTestFile = new File("ordersTest.json");
        usersTestFile = new File("usersTest.json");
        LogUtils.configLogger("C:\\Users\\Andrey\\IdeaProjects\\ACO23\\aco23\\projectZero\\src\\test\\java\\projectzero\\server\\log4j.properties");
        String externalStaticFileLocation = "C:\\Users\\Andrey\\IdeaProjects\\ACO23\\aco23\\projectZeroFront\\front";
        server = new Server(PORT, usersTestFile.getPath()
                , ordersTestFile.getPath(), externalStaticFileLocation);
        try (Writer writer = new FileWriter(ordersTestFile)) {
            writer.write("[]");
            writer.flush();
        }

        try (Writer writer = new FileWriter(usersTestFile)) {
            writer.write("[{\"email\":\"root@root.root\",\"pass\":\"root\",\"role\":\"ADMIN\"}]");
            writer.flush();
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer();
        Files.delete(ordersTestFile.toPath());
        Files.delete(usersTestFile.toPath());
    }

    @Test (expected = JoinException.class)
    public void testJoinException() throws Exception {
        HttpResponse<String> request = Unirest.post("http://localhost:9817/join")
                .body("{\"email\":\"root@root.root\",\"pass\":\"root\"}").asString();

        Exception exception = JSONUtils.fromJson(request.getBody(), JoinException.class);
        throw exception;
    }

    @Test
    public void testJoin() throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:9817/join")
                .body("{\"email\":\"An@An.com\",\"pass\":\"1234\"}").asString();
        System.out.println(response.getBody());

        Assert.assertEquals(JSONUtils.fromJson(response.getBody(), AppResponse.class).getResponse()
                , "Welcome to projectZero");
    }
}