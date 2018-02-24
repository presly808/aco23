package controller;

import model.Order;
import model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MainControllerImpl implements MainController {


    @Override
    public Map<String, User> getAllUsers() {
        return null;
    }

    @Override
    public Map<Integer, Order> getAllOrders() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public Order getOrderbyId(int id) {
        return null;
    }

    @Override
    public Map<Integer, User> filterByName(String name) {
        return null;
    }

    @Override
    public Map<Integer, User> filterByCity(String city) {
        return null;
    }

    @Override
    public Map<Integer, User> filterByReciever(String receiverName) {
        return null;
    }

    @Override
    public Map<Integer, User> filterByDate(LocalDateTime dateTime) {
        return null;
    }

    @Override
    public String changeOrderStatus(Order order) {
        return null;
    }
}
