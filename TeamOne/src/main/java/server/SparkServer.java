package server;

import appDb.AppDbImpl;
import com.google.gson.Gson;
import controller.MainController;
import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.User;
import org.apache.log4j.Logger;
import spark.Request;
import spark.Response;
import utils.Factory;
import utils.JSONUtils;
import utils.Log4JApp;

import java.util.Map;

import static spark.Spark.*;

public class SparkServer {

    private final static Logger LOGGER = Log4JApp.getLogger(Log4JApp.class);
    private Gson gson = new Gson();
    private AppDbImpl appDb = new AppDbImpl();
    // todo  modifier
    private MainController mainController = Factory.create(appDb);

    public SparkServer(int port, String staticFolder) {

        port(port);

        if(staticFolder != null) {
            externalStaticFileLocation(staticFolder);
        }
    }

    public static void main(String[] args) {

        String SERVER_PORT = System.getenv("PORT");

        if(SERVER_PORT == null){
            SERVER_PORT = "5000";
        }

        SparkServer server = new SparkServer(Integer.parseInt(SERVER_PORT),
                SparkServer.class.getResource("/view").getFile());

        before((request, response) -> response.type("application/json"));

        server.initEndpoint();
    }

    public void initEndpoint() {
        post("/login", this::login);
        post("/register", this::register);
        post("/logout", this::logout);

        get("/get_orders", (request, response) -> gson.toJson(mainController.getAllOrders().values()));
    }

    private Object login(Request request, Response response) {
        User loginUser = JSONUtils.fromJson(request.body(), User.class);

        try {
            String key = mainController.generateKey(loginUser);
//            String key = appDb.createAccessToken(loginUser);
            response.cookie("key", key, 3600);
            LOGGER.info("[login method] Auth key: " + key);
        } catch (AppException e) {
            LOGGER.error("Authorisation failed: " + e.getMessage());
            response.status(401);
            response.body(e.getMessage());

            return gson.toJson(new ServerMessage(e.getMessage()));
        }
        // gson.toJson(new Message("succes or token"))
        // todo return object decorated in json
        return gson.toJson(new ServerMessage("Login successful"));
    }

    private Object register(Request request, Response response) {
        // todo create Gson only one time and keep as a singleton

        String jsonRequest = request.body();
        User newUser = JSONUtils.fromJson(jsonRequest, User.class);
        boolean addUser = mainController.registerUser(newUser);
//        boolean addUser = appDb.register(newUser.getEmail(), newUser.getPass());

        if(addUser) {
            response.body("User successfully registered");
            LOGGER.info("User successfully registered");
        } else {
            response.body("User not added to db due to an error: Email already registered");
            LOGGER.error("User not added to db due to an error: Email already registered");
        }

        // todo return message after register logic
        return gson.toJson(new ServerMessage(response.body()));
    }

    private Object logout(Request request, Response response) {
        response.removeCookie("key");
        return gson.toJson(new ServerMessage("User logged out"));
    }

//        TODO: add this method to the page view of logged in user
//        before((request, response) -> {
//
//            boolean authenticated = request.cookie("key") != null;
//            LOGGER.info("[before method] User authenticated: " + authenticated);
//
//            if (!authenticated) {
//                halt(401, "You are not logged in");
//            }
//        });
}
