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
import projectzero.utils.EmailUtils;
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

    public Server(int port, String pathToUserJson, String pathToOrderJson) {
        this.logger = LogUtils.getLogger(Server.class);

        this.sessionMap = new HashMap<>();
        // todo remove absolute paths
        userController = new UserControllerImpl(
                new UserDao(pathToUserJson), new OrderDao(pathToOrderJson));


        port(port);
        staticFileLocation("projectzero/front");
        before((request, response) ->
                logger.info(String.format("Protocol: %s, method: %s, path: %s, body: %s",
                        request.protocol(), request.requestMethod(), request.pathInfo(), request.body())));

        initEndpoints();
    }


    private void initEndpoints() {
        post("/login", this::login);
        post("/join", this::join);
        get("/getAll", this::getAll);
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
        return key;
    }

    // join logic
    private Object join(Request request, Response response) {
        User newUser = JSONUtils.fromJson(request.body(), User.class);
        try {
            userController.join(newUser.getEmail(), newUser.getPass());
            EmailUtils.notifyUser(newUser.getEmail(),
                    "Welcome to porjectZero",
                    "Congratulation with joining up");
            // json.toJson(new MyError())
            return "{\"error\":\"\"}";
        } catch (AlreadyExistsException e) {
            // todo toJson(e) or use spark to handle errors
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    //getAll?key=
    private Object getAll(Request request, Response response) {
        String key = request.queryParams("key");
        return JSONUtils.toJson(userController.getAll(sessionMap.get(key)));
    }
}
