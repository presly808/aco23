package controller;

import appDb.AppDb;
import exceptions.AppException;
import exceptions.UserNotFoundException;
import model.Order;
import model.OrderStatus;
import model.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public interface MainController {


    Map<String, User> getAllUsers() throws AppException, IOException;
    Map<Integer, Order> getAllOrders() throws AppException, IOException;

    public void setAppDb(AppDb appDb);
    public AppDb getAppDb();

    User getById(int id) throws AppException, UserNotFoundException, IOException;

    Order getOrderbyId(int id) throws AppException, IOException;
    Map<Integer, Order> filterByName (String name) throws AppException, IOException;
    Map<Integer, Order> filterByCity (String city) throws AppException, IOException;
    Map<Integer, Order> filterByReciever (String receiverName) throws AppException, IOException;

    Map<Integer, Order> filterByDate (LocalDateTime dateTime) throws AppException, IOException;

    public String changeOrderStatus (Order order, OrderStatus orderStatus, String accessToken) throws AppException, IOException;
}
