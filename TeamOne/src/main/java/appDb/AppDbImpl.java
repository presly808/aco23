package appDb;

import com.google.gson.Gson;
import exceptions.AppException;
import exceptions.LoginCredentialException;
import exceptions.NoAccessException;
import model.Customer;
import model.Order;
import model.User;
import utils.JSONUtils;
import org.apache.log4j.Logger;
import utils.Log4JApp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// todo figure out how to set info to logging once to all methods

// todo write error msg 4 logger

public class AppDbImpl implements AppDb {

    private Map<String, User> users;
    private Map<Integer, Order> orders;
    private Map<String, User> accessTokenUserMap;
    private final String usersDbPath = "user_db.txt";
    private final String ordersDbPath = "order_db.txt";
    private static Gson gson = new Gson();
    private Logger logger;
    private LocalDateTime localDateTime;


    public AppDbImpl() {
        this.users = new HashMap<>();
        this.orders = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
        this.logger = Log4JApp.getLogger(AppDbImpl.class);
    }

    public User addUser(User user) throws AppException {

        users = getUsersFromDb(usersDbPath);
        users.put(user.getEmail(), user);
        JSONUtils.saveUsersToDb(usersDbPath, users);
        logger.info("Method" + getClass() + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        return user;
    }

    public User removeUser(User user) {

        users = getUsersFromDb(usersDbPath);
        users.remove(user.getEmail());
        JSONUtils.saveUsersToDb(usersDbPath, users);

        return user;
    }


    public Map<String, User> getUsers() {

        return getUsersFromDb(usersDbPath);
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<String, User> getUsersFromDb(String userDbPath) {
        try {
            List<User> usersList = JSONUtils.getUsersFromDb(userDbPath);
            for (User user : usersList) {
                users.put(user.getEmail(), user);
            }
        } catch (IOException e) {
            logger.error("This is Error message");
        }

        return users;
    }


    public Order addOrder(Order order, String accessToken) throws AppException {

        if (!hasToken(accessToken)) {
            logger.error("no access, login first");
            throw new NoAccessException("no access, login first");
        }

        orders = getOrdersFromDb(ordersDbPath);
        orders.put(order.getId(), order);
        JSONUtils.saveOrdersToDb(ordersDbPath, orders);

        return order;
    }

    public Map<Integer, Order> getOrdersFromDb(String ordersDbPath) {
        try {
            List<Order> ordersList = JSONUtils.getOrdersFromDb(ordersDbPath);
            for (Order order : ordersList) {
                orders.put(order.getId(), order);
            }
        } catch (IOException e) {
            //logs exception
            logger.error("This is Error message");
        }

        return orders;
    }

    public Order removeOrder(Order order, String accessToken) throws AppException {

        orders = getOrdersFromDb(ordersDbPath);

        if (!hasToken(accessToken)) {
            logger.error("no access, login first");
            throw new AppException("no access, login first");
        }
        orders.remove(order.getId());

        JSONUtils.saveOrdersToDb(ordersDbPath, orders);

        return order;
    }

    public Map<Integer, Order> getOrders() {

        return getOrdersFromDb(ordersDbPath);
    }


    public String createAccessToken(User user) throws LoginCredentialException {
        User found =
                users.values()
                        .stream()
                        .filter(u -> u.getEmail().equals(user.getEmail()))
                        .filter(u -> u.getPass().equals(user.getPass()))
                        .findFirst().orElse(null);

        if (found == null) {
            //logs exception
            logger.error("invalid login or pass");
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
