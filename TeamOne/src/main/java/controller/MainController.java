package controller;

import exceptions.AppException;
import exceptions.UserNotFoundException;
import model.Order;
import model.OrderStatus;
import model.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

// todo use exceptions in the signatures
public interface MainController {


    Map<String, User> getAllUsers() throws AppException, IOException;
    Map<Integer, Order> getAllOrders() throws AppException, IOException;

    User getById(int id) throws AppException, UserNotFoundException, IOException;
    Order getOrderbyId(int id) throws AppException, IOException;

    Map<Integer, User> filterByName (String name) throws AppException, IOException;
    Map<Integer, User> filterByCity (String city) throws AppException, IOException;
    Map<Integer, User> filterByReciever (String receiverName) throws AppException, IOException;
    Map<Integer, User> filterByDate (LocalDateTime dateTime) throws AppException, IOException;

    public String changeOrderStatus (Order order, OrderStatus orderStatus, String accessToken) throws AppException, IOException;

}
