package projectzero.server;

import org.apache.log4j.Logger;
import projectzero.controller.IEmployeeController;
import projectzero.controller.IUserController;
import projectzero.controller.UserControllerImpl;
import projectzero.dao.OrderDao;
import projectzero.dao.UserDao;
import projectzero.exceptions.AlreadyExistsException;
import projectzero.exceptions.NoSuchElementException;
import projectzero.model.User;
import projectzero.utils.JSONUtils;
import projectzero.utils.LogUtils;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {

    private IUserController userController;
    private IEmployeeController employeeController;
    private Map<String, User> sessionMap;
    private Logger logger;

    public Server(int port) {
        this.logger = LogUtils.getLogger(Server.class);
        this.sessionMap = new HashMap<>();
        // todo remove absolute paths
        userController = new UserControllerImpl(
                new UserDao("users.json"), new OrderDao("orders.json"));
        port(port);
        staticFileLocation("projectzero/front");
        before((request, response) ->
                logger.info(String.format("Protocol: %s, method: %s, path: %s",
                        request.protocol(), request.requestMethod(), request.pathInfo())));
        initEndpoints();
    }


    private void initEndpoints() {
        post("/login", this::login);
        post("/join", this::join);
    }

    // login logic
    private Object login(Request request, Response response) {
        User loginUser = JSONUtils.fromJson(request.body(), User.class);
        String key = null;
        try {
            key = userController.login(loginUser);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        if (key != null) {
            sessionMap.put(key, loginUser);
        }
        return JSONUtils.toJson(key);
    }

    // join logic
    private Object join(Request request, Response response) {
        User newUser = JSONUtils.fromJson(request.body(), User.class);
        try {
            userController.join(newUser.getEmail(), newUser.getPass());
            return "{error : \'\'}";
        } catch (AlreadyExistsException e) {
            // todo toJson(e) or use spark to handle errors
            return "{error : " + e.getMessage() + "}";
        }
    }
}
