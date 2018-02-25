package controller;

import appDb.AppDb;
import model.Customer;
import model.Order;
import model.User;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// todo the same as in appDb, create files before and remove after
// todo add test class, that will check http requests to created endpoint
// in new test class run spark -> send requests -> check results -> down spark
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