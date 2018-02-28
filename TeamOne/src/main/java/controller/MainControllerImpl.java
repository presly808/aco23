package controller;

import appDb.AppDb;
import exceptions.AppException;
import exceptions.OrderNotFoundException;
import exceptions.UserNotFoundException;
import model.Order;
import model.OrderStatus;
import model.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MainControllerImpl implements MainController {

    private AppDb appDb;
    private User user;

    public MainControllerImpl(AppDb appDb) {
        this.appDb = appDb;
    }


    public AppDb getAppDb() {
        return appDb;
    }

    public void setAppDb(AppDb appDb) {
        this.appDb = appDb;
    }

    @Override
    public Map<String, User> getAllUsers() throws AppException, IOException {
        return appDb.getUsers();
    }

    @Override
    public Map<Integer, Order> getAllOrders() throws AppException, IOException {
        return appDb.getOrders();
    }


    @Override
    public User getById(int id) throws AppException, IOException {

        //User res = appDb.getUsers().entrySet().stream().filter(user -> user.getValue().getId() == id).limit(1);
        for (User user : appDb.getUsers().values()){
            if (user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException("No user Found");
    }

    @Override
    public Order getOrderbyId(int id) throws AppException, IOException {
        for (Order order : appDb.getOrders().values()){
            if (order.getId() == id){
                return order;
            }
        }

        throw new OrderNotFoundException("No user Found");
    }

    @Override
    public Map<Integer, Order> filterByName(String name) throws AppException, IOException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getSenderName().equals(name)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByCity(String city) throws AppException, IOException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getTargetCity().equals(city)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByReciever(String receiverName) throws AppException, IOException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getReceiverName().equals(receiverName)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByDate(LocalDateTime dateTime) throws AppException, IOException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getSendDate().equals(dateTime)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public String changeOrderStatus(Order order, OrderStatus orderStatus, String accessToken) throws AppException, IOException {
        if (!appDb.hasToken(accessToken)) {
            throw new AppException("no access, login first");
        }
        order.setOrderStatus(orderStatus);
        return String.valueOf(orderStatus);

    }


}
