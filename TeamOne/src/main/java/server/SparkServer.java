package server;

import appDb.AppDbImpl;
import com.google.gson.Gson;
import controller.MainController;
import exceptions.LoginCredentialException;
import model.User;
import spark.Request;
import spark.Response;
import utils.Factory;
import utils.JSONUtils;

import static spark.Spark.*;

public class SparkServer {

    private final int port;
    private final String staticFolder;

    private AppDbImpl appDb;

    // todo  modifier
    private MainController mainController = Factory.create(true, appDb);

    public SparkServer(int port, String staticFolder) {
        this.port = port;
        this.staticFolder = staticFolder;
        this.appDb = new AppDbImpl();
        port(port);

        if(staticFolder != null) {
            externalStaticFileLocation(staticFolder);
        }

    }

    public static void main(String[] args) {

        SparkServer server = new SparkServer(8080, "TeamOne/src/main/java/view/");
        server.initEnpoint();
    }

    public void stopServer(){
        stop();
    }

    private void initEnpoint() {
        post("/login", this::login);
        post("/register", this::register);
    }

    private Object login(Request request, Response response) {
        User loginUser = JSONUtils.fromJson(request.body(), User.class);

        try {
            String key = appDb.createAccessToken(loginUser);
        } catch (LoginCredentialException e) {
            // todo wrap an exception and return either or use spark exception resolver ()
            e.printStackTrace();
        }
        // gson.toJson(new Message("succes or token"))
        // todo return object decorated in json
        return response;
    }

    private Object register(Request request, Response response) {
        // todo create Gson only one time and keep as a singleton

        String jsonRequest = request.body();

        User newUser = JSONUtils.fromJson(jsonRequest, User.class);

        appDb.register(newUser.getEmail(), newUser.getPass());
        response.body("");

        // todo return message after register logic
        return response;
    }
}
