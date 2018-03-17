package controller;

import appDb.AppDbImpl;
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

// todo add validation for input arguments
public class MainControllerImpl implements MainController {

    private AppDbImpl appDb;
    // todo we can delete user
    private User user;

    public MainControllerImpl(AppDbImpl appDb) {
        this.appDb = appDb;
    }


    public AppDbImpl getAppDb() {
        return appDb;
    }

    public void setAppDb(AppDbImpl appDb) {
        this.appDb = appDb;
    }

    @Override
    public Map<String, User> getAllUsers() throws AppException {
        return appDb.getUsers();
    }

    @Override
    public Map<Integer, Order> getAllOrders() throws AppException{
        return appDb.getOrders();
    }


    @Override
    public User getById(int id) throws UserNotFoundException {

        // todo java 8 at the end apply findFirst
        //User res = appDb.getUsers().entrySet().stream().filter(user -> user.getValue().getId() == id).limit(1);
        for (User user : appDb.getUsers().values()){
            if (user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException("No user Found");
    }

    @Override
    public Order getOrderById(int id) throws OrderNotFoundException {
        for (Order order : appDb.getOrders().values()){
            if (order.getId() == id){
                return order;
            }
        }

        throw new OrderNotFoundException("No user Found");
    }

    @Override
    public Map<Integer, Order> filterByName(String name) throws OrderNotFoundException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getSenderName().equals(name)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByCity(String city) throws OrderNotFoundException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getTargetCity().equals(city)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByReceiver(String receiverName) throws OrderNotFoundException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getReceiverName().equals(receiverName)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Order> filterByDate(LocalDateTime dateTime) throws OrderNotFoundException {
        Map<Integer, Order> result = new HashMap<>();
        for (Order order : appDb.getOrders().values()) {
            if(order.getSendDate().equals(dateTime)){
                result.put(order.getId(), order);
            }
        }
        return result;
    }

    public String changeOrderStatus(Order order, OrderStatus orderStatus, String accessToken) throws AppException, IOException {
        if (!appDb.hasToken(accessToken)) {
            throw new AppException("no access, login first");
        }
        order.setOrderStatus(orderStatus);
        return String.valueOf(orderStatus);
    }


}
