package server;

import com.google.gson.Gson;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by serhii on 18.02.18.
 */
public class TestServer {

    public static void main(String[] args) {
        port(9898);
        get("/", (request, response) -> "Hello");
        get("/items" , (request, response) -> new Gson().toJson(new String[]{"item1", "item2", "item3"}));

    }
}
