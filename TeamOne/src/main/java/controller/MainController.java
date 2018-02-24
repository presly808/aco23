package controller;

import model.Order;
import model.User;

import java.time.LocalDateTime;
import java.util.Map;

public interface MainController {


    Map<String, User> getAllUsers();
    Map<String, Order> getAllOrders();

    User getById(int id);
    Order getOrderbyId(int id);

    Map<String, User> filterByName (String name);
    Map<String, User> filterByCity (String city);
    Map<String, User> filterByReciever (String receiverName);
    Map<String, User> filterByDate (LocalDateTime dateTime);

    public String changeOrderStatus (Order order);

}
