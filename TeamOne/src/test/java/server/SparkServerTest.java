package server;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import exceptions.AppException;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static spark.Spark.*;
import spark.Spark;

// in new test class run spark -> send requests -> check results -> down spark

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SparkServerTest {

    @BeforeClass
    public static void before() throws AppException {
        String SERVER_PORT = "5000";
        SparkServer server = new SparkServer(Integer.parseInt(SERVER_PORT),
                SparkServer.class.getResource("/view").getFile());
        server.initEndpoint();
        Spark.before((request, response) -> response.type("application/json"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        stop();
    }

    @Test
    public void test1_addNewUserToDb() throws UnirestException{
        HttpResponse<JsonNode> jsonResponse = Unirest
            .post("http://localhost:5000/register")
            .header("Content-Type", "application/json")
            .body("{\"email\":\"mail1@gmail.com\",\"pass\":\"111\"}")
            .asJson();
        assertEquals("User successfully registered",
                jsonResponse.getBody().getObject().get("message"));
    }

    @Test
    public void test2_addExistingUserToDb() throws UnirestException{
        HttpResponse<JsonNode> jsonResponse = Unirest
            .post("http://localhost:5000/register")
            .header("Content-Type", "application/json")
            .body("{\"email\":\"mail1@gmail.com\",\"pass\":\"111\"}")
            .asJson();
        assertEquals("User not added to db due to an error: Email already registered",
                jsonResponse.getBody().getObject().get("message"));
    }

    @Test
    public void test3_loginUser() throws UnirestException{
        HttpResponse<JsonNode> response = Unirest
                .post("http://localhost:5000/login")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"mail1@gmail.com\",\"pass\":\"111\"}")
                .asJson();
        assertEquals("Login successful",
                response.getBody().getObject().get("message"));
//        cookie is set
        assertTrue(response.getHeaders().containsKey("set-cookie"));
        assertEquals(1, response.getHeaders().get("set-cookie").size());
    }

    @Test
    public void test4_getOrders() throws UnirestException{
        HttpResponse<JsonNode> response = Unirest
                .get("http://localhost:5000/get_orders")
                .asJson();
        assertTrue(response.getBody().getArray().length() > 0);
    }

    @Test
    public void test5_loginUserInvalidPassword() throws UnirestException{
        HttpResponse<JsonNode> response = Unirest
                .post("http://localhost:5000/login")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"mail1@gmail.com\",\"pass\":\"222\"}")
                .asJson();
        assertEquals(401, response.getStatus());
        //        no cookie set
        assertFalse(response.getHeaders().containsKey("set-cookie"));
    }

    @Test
    public void test6_loginNonExistingUser() throws UnirestException{
        HttpResponse<JsonNode> response = Unirest
                .post("http://localhost:5000/login")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"mail111@gmail.com\",\"pass\":\"123\"}")
                .asJson();
        assertEquals(401, response.getStatus());
        //        no cookie set
        assertFalse(response.getHeaders().containsKey("set-cookie"));
    }

    @Test
    public void test7_logoutUser() throws UnirestException{
        HttpResponse<JsonNode> response = Unirest
                .post("http://localhost:5000/login")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"mail1@gmail.com\",\"pass\":\"111\"}")
                .asJson();

//        cookie is set
        assertTrue(response.getHeaders().containsKey("set-cookie"));
        assertEquals(1, response.getHeaders().get("set-cookie").size());

        HttpResponse<JsonNode> responseLogout = Unirest
                .post("http://localhost:5000/logout")
                .asJson();
//        TODO: verify that cookie removed
        assertEquals(1, responseLogout.getHeaders().get("set-cookie").size());
        assertEquals("User logged out",
                responseLogout.getBody().getObject().get("message"));

    }
}
