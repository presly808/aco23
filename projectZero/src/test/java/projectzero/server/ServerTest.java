package projectzero.server;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.*;
import projectzero.exceptions.JoinException;
import projectzero.exceptions.LoginException;
import projectzero.model.AppResponse;
import projectzero.model.Role;
import projectzero.model.User;
import projectzero.utils.JSONUtils;
import projectzero.utils.LogUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

public class ServerTest {

    public static final int PORT = 9817;
    private static Server server;
    private static File ordersTestFile;
    private static File usersTestFile;
    private static User user;

    @BeforeClass
    public static void setUpClass() throws Exception {
        ordersTestFile = new File("ordersTest.json");
        usersTestFile = new File("usersTest.json");

        LogUtils.configLogger("C:\\Users\\Andrey\\IdeaProjects\\ACO23\\aco23\\projectZero\\src\\test\\java\\projectzero\\server\\log4j.properties");
        String externalStaticFileLocation = "C:\\Users\\Andrey\\IdeaProjects\\ACO23\\aco23\\projectZeroFront\\front";
        server = new Server(PORT, usersTestFile.getPath()
                , ordersTestFile.getPath(), externalStaticFileLocation);
    }

    @Before
    public void setUp() throws IOException {
        user = new User("An@an.com", "1234", Role.ADMIN);

        try (Writer writer = new FileWriter(ordersTestFile)) {
            writer.write("[{" +
                    "  \"id\": 0," +
                    "  \"title\": \"Title\"," +
                    "  \"description\": \"descr\"," +
                    "  \"price\": 100," +
                    "  \"status\": \"Good\"," +
                    "  \"openedTime\": {" +
                    "    \"date\": {" +
                    "      \"year\": 2018," +
                    "      \"month\": 3," +
                    "      \"day\": 1" +
                    "    }," +
                    "    \"time\": {" +
                    "      \"hour\": 18," +
                    "      \"minute\": 31, " +
                    "      \"second\": 35," +
                    "      \"nano\": 123000000" +
                    "    }" +
                    "  }," +
                    "  \"owner\": {" +
                    "    \"email\": \"Les@gmail.com\"," +
                    "    \"pass\": \"pass\"," +
                    "    \"role\": \"USER\"" +
                    "  }" +
                    "}]");
            writer.write("[{" +
                    "  \"id\": 0," +
                    "  \"title\": \"Title\"," +
                    "  \"description\": \"descr\"," +
                    "  \"price\": 100," +
                    "  \"status\": \"Good\"," +
                    "  \"openedTime\": {" +
                    "    \"date\": {" +
                    "      \"year\": 2018," +
                    "      \"month\": 3," +
                    "      \"day\": 1" +
                    "    }," +
                    "    \"time\": {" +
                    "      \"hour\": 18," +
                    "      \"minute\": 31, " +
                    "      \"second\": 35," +
                    "      \"nano\": 123000000" +
                    "    }" +
                    "  }," +
                    "  \"owner\": {" +
                    "    \"email\": \"An@An.An\"," +
                    "    \"pass\": \"An\"," +
                    "    \"role\": \"USER\"" +
                    "  }" +
                    "}]");
            writer.flush();
        }

        try (Writer writer = new FileWriter(usersTestFile)) {
            writer.write("[{\"email\":\"root@root.root\",\"pass\":\"root\",\"role\":\"ADMIN\"}]");
            writer.flush();
        }
    }

    @AfterClass
    public static void tearDownClass() {
        server.stopServer();
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(ordersTestFile.toPath());
        Files.delete(usersTestFile.toPath());
    }

    @Test(expected = JoinException.class)
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
/*        System.out.println(response.getBody());*/
        Assert.assertEquals(JSONUtils.fromJson(response.getBody(), AppResponse.class).getResponse()
                , "Welcome to projectZero");
    }

    @Test
    public void testLogin() throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:9817/login")
                .body("{\"email\":\"root@root.root\",\"pass\":\"root\"}").asString();
/*        System.out.println(response.getBody());
        System.out.println(response.getHeaders());*/
        Assert.assertEquals(JSONUtils.fromJson(response.getBody(), AppResponse.class).getResponse()
                , "ADMIN");
        Assert.assertTrue(response.getHeaders().containsKey("key"));

    }

    @Test (expected = LoginException.class)
    public void testLoginExeption() throws UnirestException, LoginException {
        HttpResponse<String> response = Unirest.post("http://localhost:9817/login")
                .body("{\"email\":\"An@an.an\",\"pass\":\"an\"}").asString();
/*        System.out.println(response.getBody());
        System.out.println(response.getHeaders());*/
        throw JSONUtils.fromJson(response.getBody(), LoginException.class);
    }

    //TODO finish test for getAll method
    @Test
    public void testGetAll() throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:9817/getAll")
                .body("{\"email\":\"An@An.An\",\"pass\":\"An\"}").asString();
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}