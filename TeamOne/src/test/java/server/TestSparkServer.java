package server;

import static spark.Spark.*;

public class TestSparkServer {


    public static void main(String[] args) {
        final int PORT = 8080;
        final String STATIC_FOLDER = "TeamOne/src/main/java/view/";

        port(PORT);
        externalStaticFileLocation(STATIC_FOLDER);

        get("/index.html", (request, response) -> "Server is up");

        get("/home", (request, response) -> "Server is up");

    }
}
