package controller;

import appDb.AppDb;
import model.Order;
import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainControllerImplTest {

    MainController mainController = new MainControllerImpl(new AppDb());
    AppDb appDb = new AppDb();
    User testUser = new User("test@gmail.com", "123456");
    Order testOrder = new Order("Oleg", "Andrey", "Kyiv");

    @Test
    public void getAllUsers() {
        assertEquals(1, mainController.getAllUsers().size());

    }

    @Test
    public void getAllOrders() {
        assertEquals(1, mainController.getAllOrders().size());
    }

    @Test
    public void getById() {
        testUser.setId(1);
        assertEquals(testUser, mainController.getById(1));
    }

    @Test
    public void getOrderbyId() {
        testOrder.setId(1);
        assertEquals(testOrder, mainController.getOrderbyId(1));
    }

    @Test
    public void filterByName() {
    }

    @Test
    public void filterByCity() {
    }

    @Test
    public void filterByReciever() {
    }

    @Test
    public void filterByDate() {
    }

    @Test
    public void changeOrderStatus() {
    }
}