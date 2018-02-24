package controller;

import model.Order;
import model.User;

import java.time.LocalDateTime;
import java.util.Map;

public interface MainController {


    Map<String, User> getAllUsers();
    Map<Integer, Order> getAllOrders();

    User getById(int id);
    Order getOrderbyId(int id);

    Map<Integer, User> filterByName (String name);
    Map<Integer, User> filterByCity (String city);
    Map<Integer, User> filterByReciever (String receiverName);
    Map<Integer, User> filterByDate (LocalDateTime dateTime);

    public String changeOrderStatus (Order order);

}
