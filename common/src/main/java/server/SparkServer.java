package server;

import static spark.Spark.*;

public class SparkServer {

    private int port;
    private String staticFolder;

    public SparkServer(int port, String staticFolder) {
        this.port = port;
        this.staticFolder = staticFolder;

        port(port);
        externalStaticFileLocation(staticFolder);

        get("/", (request, response) -> "Server is up");

    }

    public void stopServer(){
        stop();
    }
}
