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

public class AppDb {

    private Map<String, User> users;
    private Map<Integer, Order> orders;
    private Map<String, User> accessTokenUserMap;

    public AppDb() {
        this.users = new HashMap<>();
        this.orders = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
    }

    // todo we need to assign id to the user
    public User addUser(User user) throws AppException {

        users.put(user.getEmail(), user);
        try {
            JSONUtils.addUser("user_db.txt", user);
        } catch (IOException e) {
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
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
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

    public static  void restorDb() {
        Gson gson = new Gson();

        User user1 = new User("test@gmail.com", "123456");
        User user2 = new User("test@gmail.com", "123456");
        User user3 = new User("test@gmail.com", "123456");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        File file = new File("user_db.txt");
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(users));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
