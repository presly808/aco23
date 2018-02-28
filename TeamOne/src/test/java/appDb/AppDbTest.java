package appDb;

import com.google.gson.Gson;
import exceptions.AppException;
import model.Order;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// todo use test db file
// remove db file in afterClass
public class AppDbTest {

    AppDb appDb = new AppDb();
    User testUser = new User("test3@gmail.com", "123456");
    Order testOrder = new Order("Oleg", "Andrey", "Kyiv");

    Gson gson = new Gson();

    @Before
    public void before() throws AppException {
        Map<String, User> users = appDb.getUsers();
        appDb.addUser(testUser);
        String token = appDb.createAccessToken(testUser);
        appDb.addOrder(testOrder, token);

    }


    @After
    public void after(){

        AppDb.restorDb();
        appDb = null;

    }

    @Test
    public void addUser() throws AppException {
        User testUser1 = new User("test4@gmail.com", "123456");
        appDb.addUser(testUser1);
        assertTrue(appDb.getUsers().containsKey("test4@gmail.com"));
    }

    @Test
    public void removeUser() throws AppException {
        appDb.removeUser(testUser);
        assertEquals(2, appDb.getUsers().size());
    }

    @Test
    public void addOrder() throws AppException {

        int testOrderId = testOrder.getId();
        assertEquals(1, appDb.getOrders().size());
        assertTrue(appDb.getOrders().containsKey(testOrderId));
    }

    @Test
    public void removeOrder() throws AppException {
        String token = appDb.createAccessToken(testUser);
        appDb.removeOrder(testOrder, token);
        assertEquals(0,appDb.getOrders().size());
    }

    @Test
    public void getUsers() throws AppException {
        appDb.addUser(testUser);
        assertTrue(appDb.getUsers().containsKey("test3@gmail.com"));
    }

}