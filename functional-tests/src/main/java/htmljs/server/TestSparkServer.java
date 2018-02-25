package htmljs.server;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by serhii on 18.02.18.
 */
public class TestSparkServer {

    private Map<Integer, Product> productMap = new HashMap<>();
    private Gson gson = new Gson();

    public TestSparkServer(int port, String resourcePath) {

        initDataForServer();

        port(port);

        if(resourcePath != null){
            externalStaticFileLocation(resourcePath);
        }

        enableCORS("*", "*","*");

        initEndpoints();

    }

    public void stopServer(){
        stop();
    }

    private void initEndpoints() {

        get("/hello", (request, response) -> "Hello");

        get("/product/get/:id",
                (request, response) -> gson.toJson(productMap.get(Integer.parseInt(request.params("id")))));

        post("/product/add", (request, response) -> {
            String jsonStr = request.body();
            Product product = gson.fromJson(jsonStr, Product.class);
            productMap.put(product.id, product);

            return gson.toJson(new Message("operation was successful"));
        });

        get("/product/all", (request, response) -> gson.toJson(productMap.values()));
    }

    private void initDataForServer() {
        productMap.put(1, new Product(1, 230, "ananas"));
        productMap.put(2, new Product(2, 50, "avacodo"));
        productMap.put(3, new Product(3, 30, "shaurma"));
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

    public static void main(String[] args) {
        new TestSparkServer(8989,TestSparkServer.class.getResource("/htmljs").getFile());
    }

    public static class Message {
        String text;

        public Message(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    private static class Product {
        int id;
        int price;
        String name;

        public Product() {
        }

        public Product(int id, int price, String name) {
            this.id = id;
            this.price = price;
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
