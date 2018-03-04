package appDb;

import com.google.gson.Gson;
import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.Customer;
import model.Order;
import model.User;
import utils.JSONUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

// todo make inteface for AppDB, follow DI principle in SOLID
public class AppDb {

    private Map<String, User> users;
    private Map<Integer, Order> orders;
    private Map<String, User> accessTokenUserMap;


    public AppDb() {
        this.users = new HashMap<>();
        this.orders = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
    }

    public User addUser(User user) throws AppException {

        users.put(user.getEmail(), user);
        try {
            JSONUtils.addUser("user_db.txt", user);
        } catch (IOException e) {
            // todo should be logged like other events
            e.printStackTrace();
        }
        return user;
    }

    public User removeUser(User user) {
        users.remove(user.getEmail());
        return user;
    }

    public Order addOrder(Order order, String accessToken) throws AppException {

        if (!hasToken(accessToken)) {
            throw new AppException("no access, login first");
        }

        try {
            JSONUtils.addOrder("order_db.txt", order);
        } catch (IOException e) {
            e.printStackTrace();
        }

        orders.put(order.getId(), order);
        return order;
    }

    public Order removeOrder(Order order, String accessToken) throws AppException {

        if (!hasToken(accessToken)) {
            throw new AppException("no access, login first");
        }
        orders.remove(order.getId());
        return order;
    }

    public Map<String, User> getUsers() {
        try {
            List<User> usersList = JSONUtils.getUsersFromDb("user_db.txt");
            for (User user : usersList) {
                users.put(user.getEmail(), user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<Integer, Order> getOrders() {
        try {
            List<Order> ordersList = JSONUtils.getOrdersFromDb("order_db.txt");
            for (Order order : ordersList) {
                orders.put(order.getId(), order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }


    public String createAccessToken(User user) throws LoginCredentialException {
        User found =
                users.values()
                        .stream()
                        .filter(u -> u.getEmail().equals(user.getEmail()))
                        .filter(u -> u.getPass().equals(user.getPass()))
                        .findFirst().orElse(null);

        if (found == null) {
            throw new LoginCredentialException("invalid login or pass");
        } else {
            String accessKey = UUID.randomUUID().toString();
            accessTokenUserMap.put(accessKey, found);
            return accessKey;
        }
    }

    public boolean hasToken(String accessToken) {
        return accessTokenUserMap.containsKey(accessToken);
    }

    public void register(String email, String pass) {
        users.put(email, new Customer(email, pass));
    }

    public static  void restoreUserDb() {
        Gson gson = new Gson();

        User user1 = new User("test@gmail.com", "123456");
        User user2 = new User("test@gmail.com", "123456");
        User user3 = new User("test@gmail.com", "123456");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        // todo all paths should be visible and extracted to appropriated place
        File file = new File("user_db.txt");
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(users));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void restoreOrderDb() {
        Gson gson = new Gson();

        // such logic is not for this class, create your utilites
        Order order1 = new Order("Oleg", "Andrey", "Kyiv");
        Order order2 = new Order("Yuriy", "Andrey", "Kyiv");
        Order order3 = new Order("Ivan", "Andrey", "Kyiv");


        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        order1.setId(1);
        order2.setId(2);
        order3.setId(3);


        File file = new File("order_db.txt");
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(orders));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
