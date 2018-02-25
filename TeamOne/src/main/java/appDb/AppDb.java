package appDb;

import exceptions.LoginCredentialException;
import model.Customer;
import model.Order;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public User addUser(User user) {
        users.put(user.getEmail(), user);
        return user;
    }

    public User removeUser(User user) {
        users.remove(user.getEmail());
        return user;
    }

    public Order addOrder(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Order removeOrder(Order order) {
        orders.remove(order.getId());
        return order;
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
}
