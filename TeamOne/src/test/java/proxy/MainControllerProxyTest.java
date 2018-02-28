package proxy;

import appDb.AppDb;
import controller.MainController;
import exceptions.AppException;
import model.Order;
import model.User;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Factory;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class MainControllerProxyTest {
    AppDb appDb = new AppDb();
    MainController mainController = Factory.create(true, appDb);
    User testUser = new User("test@gmail.com", "123456");
    Order testOrder = new Order("Oleg", "Andrey", "Kyiv");


    @Before
    public void before() throws AppException {
        Map<String, User> users = appDb.getUsers();
        appDb.addUser(testUser);
        String token = appDb.createAccessToken(testUser);
        appDb.addOrder(testOrder, token);

    }


    @After
    public void after(){
        AppDb.restoreUserDb();
        AppDb.restoreOrderDb();

        appDb = null;
    }

    @Test
    public void getAllUsers() throws IOException, AppException {
        assertEquals(1, mainController.getAllUsers().size());
    }

    @Test
    public void getAllOrders() throws IOException, AppException {
        assertEquals(4, mainController.getAllOrders().size());

    }

    @Test
    public void getById() throws AppException, IOException {
        assertEquals(testUser, mainController.getById(testUser.getId()));

    }

    @Test
    public void getOrderbyId() throws AppException, IOException {
        String token = appDb.createAccessToken(testUser);
        testOrder.setId(1);
        appDb.addOrder(testOrder, token);
        assertEquals(testOrder.getId(), mainController.getOrderbyId(testOrder.getId()).getId());
    }

    @Test
    public void filterByName() throws AppException, IOException {

        String token = appDb.createAccessToken(testUser);
        appDb.addOrder(new Order("Andrey", "Andrey", "Kyiv"), token);
        appDb.addOrder(new Order("Oleg", "Andrey", "Kyiv"), token);
        appDb.addOrder(new Order("Oleg", "Andrey", "Kyiv"), token);

        assertThat(mainController.filterByName("Andrey").size(), CoreMatchers.equalTo(1));
        assertThat(mainController.filterByName("Oleg").size(), CoreMatchers.equalTo(4));
    }

    @Test
    public void filterByCity() throws AppException, IOException {
        String token = appDb.createAccessToken(testUser);
        Order testOrder2 = new Order("Oleg", "Andrey", "Kyiv");
        appDb.addOrder(new Order("Andrey", "Andrey", "Lviv"), token);
        appDb.addOrder(new Order("Oleg", "Andrey", "Kyiv"), token);
        appDb.addOrder(testOrder2, token);

        assertThat(mainController.filterByCity("Kyiv").size(), CoreMatchers.equalTo(6));
        assertThat(mainController.filterByCity("Lviv").size(), CoreMatchers.equalTo(1));
    }
}