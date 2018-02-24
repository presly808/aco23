package appDb;

import model.Order;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class AppDb {

    private Map <String, User> users;
    private Map <Integer, Order> orders;

    public AppDb(){
        this.users = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public User addUser (User user){

        users.put(user.getEmail(), user);
        return user;
    }

    public User removeUser (User user){
        return null;
    }

    public Order addOrder (Order order){
        return null;
    }

    public Order removeOrder (Order order){
        return null;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }
}
