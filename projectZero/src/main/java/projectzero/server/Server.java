package projectzero.server;

import projectzero.controller.IEmployeeController;
import projectzero.controller.IUserController;
import projectzero.controller.UserControllerImpl;
import projectzero.dao.UserDao;
import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.User;
import projectzero.utils.JSONUtils;
import spark.Filter;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {

    private IUserController userController;
    private IEmployeeController employeeController;
    private Map<String, User> sessionMap;

    public Server(int port, String storagePath) {
        this.sessionMap = new HashMap<>();
        userController = new UserControllerImpl(
                new UserDao("C:\\Users\\Foresstt\\Desktop\\ArtCode\\aco23\\projectZero\\src\\main\\resources\\users.json"));
        port(port);
        externalStaticFileLocation(storagePath);
        before((request, response) ->
                System.out.println(String.format("Protocol: %s, method: %s, path: %s", request.protocol(), request.requestMethod(), request.pathInfo())));
        initEnpoint();
    }

    public static void main(String[] args) {
        new Server(9817,
                "C:\\Users\\Foresstt\\Desktop" +
                        "\\ArtCode\\aco23\\projectZero\\src\\main\\java\\projectzero\\front\\");
    }

    private void initEnpoint() {
        post("/login", this::login);
        post("/join", this::join);
    }

    // login logic
    private Object login(Request request, Response response) {
        User loginUser = JSONUtils.fromJson(request.body(), User.class);
        System.out.println(loginUser);
        String key = userController.login(loginUser);
        if (key != null) {
            sessionMap.put(key, loginUser);
        }
        return JSONUtils.toJson(key);
    }

    // join logic
    private Object join(Request request, Response response) {
        User newUser = JSONUtils.fromJson(request.body(), User.class);
        System.out.println(newUser);
        try {
            userController.join(newUser.getEmail(), newUser.getPass());
            return "{error : \'\'}";
        } catch (AlreadyExistsException e) {
            return "{error : " + e.getMessage() + "}";
        }
    }
}
