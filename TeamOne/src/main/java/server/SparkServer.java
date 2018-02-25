package server;

import static spark.Spark.*;

public class SparkServer {

    private final int port;
    private final String staticFolder;

    public SparkServer(int port, String staticFolder) {
        this.port = port;
        this.staticFolder = staticFolder;

        port(port);
        externalStaticFileLocation(staticFolder);

//        get("/index.html", (request, response) -> "Server is up");

    }

    public void stopServer(){
        stop();
    }
}
