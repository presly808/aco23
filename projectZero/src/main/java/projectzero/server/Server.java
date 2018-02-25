package projectzero.server;

import projectzero.controller.IEmployeeController;
import projectzero.controller.IUserController;
import projectzero.controller.UserControllerImpl;
import projectzero.dao.UserDao;
import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.User;
import projectzero.utils.JSONUtils;
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
        exception(Exception.class, ((exception, request, response) -> System.out.println(exception.getMessage()))); // TODO: 24-Feb-18 Logger
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

        String key = userController.login(loginUser);
        if (key != null) {
            response.header("key", key);
            sessionMap.put(key, loginUser);
        }
        return response;
    }

    // join logic
    private Object join(Request request, Response response) {
        User newUser = JSONUtils.fromJson(request.body(), User.class);

        try {
            userController.join(newUser.getEmail(), newUser.getPass());
            response.body("{error : \'\'}");
        } catch (AlreadyExistsException e) {
            response.body("{error : " + e.getMessage() + "}");
        }
        return response;
    }
}
