package server;

import static spark.Spark.*;

public class TestSparkServer {


    public static void main(String[] args) {
        new TestSparkServer(8080, TestSparkServer.class.getResource("/view").getFile());

    }

    private TestSparkServer(int port, String resourcePath) {

        port(port);

        if(resourcePath != null){
            externalStaticFileLocation(resourcePath);
        }

        enableCORS("*", "*","*");


    }

    private static void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
    }
}
