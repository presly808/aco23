package appDb;

import model.Employee;
import model.Order;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppDb {

    private Map <String, User> users;
    private Map <String, Order> orders;

    public AppDb(){
        this.users = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public User addUser (User user){
        return null;
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


}
