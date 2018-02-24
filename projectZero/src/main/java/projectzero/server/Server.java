package projectzero.server;

import projectzero.controller.IEmployeeController;
import projectzero.controller.IUserController;
import projectzero.model.User;
import projectzero.utils.KeyUtils;
import spark.Request;
import spark.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {

    private IUserController userController;
    private IEmployeeController employeeController;
    private Map<String, User> sessionMap;

    public Server(int port, String storagePath) {
        this.sessionMap = new HashMap<>();
        port(port);
        externalStaticFileLocation(storagePath);
        exception(Exception.class, ((exception, request, response) -> {
            System.out.println(exception.getMessage());
        }));
        initEndpoint();
    }

    public static void main(String[] args) {
        new Server(9817,
                "C:\\Users\\Foresstt\\Desktop" +
                        "\\ArtCode\\aco23\\projectZero\\src\\main\\java\\projectzero\\front\\");
    }

    private void initEndpoint() {
        post("/login", this::login);
        post("/join", this::join);
    }

    private Object login(Request request, Response response) {
        String[] body = request.body().split("&");
        String email = body[0].split("=")[1];
        String pass = body[1].split("=")[1];
        String key = KeyUtils.getUniqueKey();
        sessionMap.put(key, new User(email, pass));
        System.out.println(sessionMap.get(key));
        return key;
    }

    private Object join(Request request, Response response) {
        String[] body = request.body().split("&");
        String email = body[0].split("=")[1];
        String pass = body[1].split("=")[1];
        try {
            email = URLDecoder.decode(email, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO: 24-Feb-18 logger
        }
        System.out.println(email + " " +pass);
        // TODO: 24-Feb-18 create new User, return true if user exists return error
        return "Hello";
    }
}
