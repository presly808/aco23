package appDb;

import model.Order;
import model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppDbTest {

    AppDb appDb = new AppDb();
    User testUser = new User("test@gmail.com", "123456");
    Order testOrder = new Order("Oleg", "Andrey", "Kyiv");

    @Test
    public void addUser() {
        appDb.addUser(testUser);
        assertTrue(appDb.getUsers().containsKey("test@gmail.com"));
    }

    @Test
    public void removeUser() {
        appDb.addUser(testUser);
        appDb.removeUser(testUser);
        assertEquals(0,appDb.getUsers().size());
    }

    @Test
    public void addOrder() {
        appDb.addOrder(testOrder);
        int testOrderId = testOrder.getId();
        assertEquals(1, appDb.getOrders().size());
        assertTrue(appDb.getOrders().containsKey(testOrderId));
    }

    @Test
    public void removeOrder() {
        appDb.addOrder(testOrder);
        appDb.removeOrder(testOrder);
        assertEquals(0,appDb.getOrders().size());
    }

    @Test
    public void getUsers() {
        appDb.addUser(testUser);
        assertTrue(appDb.getUsers().containsKey("test@gmail.com"));
    }
}