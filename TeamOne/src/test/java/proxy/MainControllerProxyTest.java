package proxy;

import appDb.AppDb;
import controller.MainController;
import controller.MainControllerImpl;
import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.Order;
import model.User;
import org.hamcrest.CoreMatchers;
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
    public void getAllOrders() throws IOException, AppException {
        assertEquals(1, mainController.getAllOrders().size());

    }

    @Test
    public void getById() throws AppException, IOException {
        testUser.setId(1);
        assertEquals(testUser, mainController.getById(1));
    }

    @Test
    public void getOrderbyId() throws AppException, IOException {
        String token = appDb.createAccessToken(testUser);
        testOrder.setId(1);
        appDb.addOrder(testOrder, token);
        assertEquals(testOrder, mainController.getOrderbyId(1));
    }

    @Test
    public void filterByName() throws AppException, IOException {

        String token = appDb.createAccessToken(testUser);
        Order testOrder2 = new Order("Oleg", "Andrey", "Kyiv");
        appDb.addOrder(new Order("Andrey", "Andrey", "Kyiv"), token);
        appDb.addOrder(new Order("Oleg", "Andrey", "Kyiv"), token);
        appDb.addOrder(testOrder2, token);

        assertThat(mainController.filterByName("Andrey").size(), CoreMatchers.equalTo(1));
        assertThat(mainController.filterByName("Oleg").size(), CoreMatchers.equalTo(3));
    }

    @Test
    public void filterByCity() throws AppException, IOException {
        String token = appDb.createAccessToken(testUser);
        Order testOrder2 = new Order("Oleg", "Andrey", "Kyiv");
        appDb.addOrder(new Order("Andrey", "Andrey", "Lviv"), token);
        appDb.addOrder(new Order("Oleg", "Andrey", "Kyiv"), token);
        appDb.addOrder(testOrder2, token);

        assertThat(mainController.filterByCity("Kyiv").size(), CoreMatchers.equalTo(3));
        assertThat(mainController.filterByCity("Lviv").size(), CoreMatchers.equalTo(1));
    }
}