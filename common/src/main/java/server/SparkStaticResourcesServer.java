package server;

import static spark.Spark.*;

public class SparkStaticResourcesServer {

    private int port;
    private String staticFolder;

    public SparkStaticResourcesServer(int port, String staticFolder) {
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
