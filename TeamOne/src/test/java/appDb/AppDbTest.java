package appDb;

import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.Order;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// todo use test db file
// create db file in beforeClass
// remove db file in afterClass
public class AppDbTest {

    AppDb appDb = new AppDb();
    User testUser = new User("test@gmail.com", "123456");
    Order testOrder = new Order("Oleg", "Andrey", "Kyiv");

    @Before
    public void before() throws AppException {
        appDb.addUser(testUser);
        String token = appDb.createAccessToken(testUser);
        appDb.addOrder(testOrder, token);

    }


    @After
    public void after(){
        appDb = null;
    }

    @Test
    public void addUser() throws AppException {

        assertTrue(appDb.getUsers().containsKey("test@gmail.com"));
    }

    @Test
    public void removeUser() throws AppException {
        appDb.removeUser(testUser);
        assertEquals(0,appDb.getUsers().size());
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
        assertTrue(appDb.getUsers().containsKey("test@gmail.com"));
    }
}