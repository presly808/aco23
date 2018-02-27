package proxy;

import appDb.AppDb;
import controller.MainController;
import controller.MainControllerImpl;
import exceptions.AppException;
import model.Order;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Factory;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainControllerProxyTest {
    AppDb appDb = new AppDb();
    MainController mainController = Factory.create(true, appDb);
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
    }

    @Test
    public void getAllUsers() throws IOException, AppException {
        assertEquals(1, mainController.getAllUsers().size());
    }

    @Test
    public void getAllOrders() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getOrderbyId() {
    }

    @Test
    public void filterByName() {
    }
}