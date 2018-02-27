package server;

import appDb.AppDb;
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
    private AppDb appDb = new AppDb();
    MainController mainController = Factory.create(true, appDb);

    public SparkServer(int port, String staticFolder) {
        this.port = port;
        this.staticFolder = staticFolder;

        port(port);
        externalStaticFileLocation(staticFolder);

//        get("/index.html", (request, response) -> "Server is up");

    }

    public static void main(String[] args) {

        new SparkServer(8080, "TeamOne/src/main/java/view/");

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
        User newUser = JSONUtils.fromJson(request.body(), User.class);
        appDb.register(newUser.getEmail(), newUser.getPass());
        response.body("");

        // todo return message after register logic
        return response;
    }
}
