package controller;

import appDb.AppDb;
import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.Customer;
import model.Order;
import model.User;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// todo the same as in appDb, create files before and remove after
// todo add test class, that will check http requests to created endpoint
// in new test class run spark -> send requests -> check results -> down spark
public class MainControllerImplTest {

    AppDb appDb = new AppDb();
    MainController mainController = new MainControllerImpl(appDb);
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
    public void getAllUsers() throws AppException {
        assertEquals(1, mainController.getAllUsers().size());

    }

    @Test
    public void getAllOrders() throws AppException {
        assertEquals(1, mainController.getAllOrders().size());
    }

    @Test
    public void getById() throws AppException {
        testUser.setId(1);
        assertEquals(testUser, mainController.getById(1));
    }

    @Test
    public void getOrderbyId() throws AppException {
        String token = appDb.createAccessToken(testUser);
        testOrder.setId(1);
        appDb.addOrder(testOrder, token);
        assertEquals(testOrder, mainController.getOrderbyId(1));
    }

    @Test
    public void filterByName() throws AppException {

        Customer user1 = new Customer();
        Customer user2 = new Customer();
        Customer user3 = new Customer();

        user1.setName("Ira");
        user2.setName("Ira");
        user3.setName("Ivan");

        appDb.addUser(user1);
        appDb.addUser(user2);
        appDb.addUser(user3);

        assertThat(mainController.filterByName("Ira").size(), CoreMatchers.equalTo(2));

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