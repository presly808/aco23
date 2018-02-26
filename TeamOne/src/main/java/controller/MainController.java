package controller;

import exceptions.AppException;
import exceptions.UserNotFoundException;
import model.Order;
import model.OrderStatus;
import model.User;

import java.time.LocalDateTime;
import java.util.Map;

// todo use exceptions in the signatures
public interface MainController {


    Map<String, User> getAllUsers() throws AppException;
    Map<Integer, Order> getAllOrders() throws AppException;

    User getById(int id) throws AppException, UserNotFoundException;
    Order getOrderbyId(int id) throws AppException;

    Map<Integer, User> filterByName (String name) throws AppException;
    Map<Integer, User> filterByCity (String city) throws AppException;
    Map<Integer, User> filterByReciever (String receiverName) throws AppException;
    Map<Integer, User> filterByDate (LocalDateTime dateTime) throws AppException;

    public String changeOrderStatus (Order order, OrderStatus orderStatus, String accessToken) throws AppException;

}
