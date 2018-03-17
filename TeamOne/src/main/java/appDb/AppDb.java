package appDb;

import exceptions.AppException;
import exceptions.LoginCredentialException;
import model.Order;
import model.User;

import java.util.Map;

// todo use exceptions
public interface AppDb {


    User addUser(User user) throws AppException;

    User removeUser(User user);

    Map<String, User> getUsers();

    void setUsers(Map<String, User> users);

    Map<String, User> getUsersFromDb(String userDbPath);

    Order addOrder(Order order, String accessToken) throws AppException;

    Map<Integer, Order> getOrdersFromDb(String ordersDbPath);

    Order removeOrder(Order order, String accessToken) throws AppException;

    Map<Integer, Order> getOrders();

    String createAccessToken(User user) throws LoginCredentialException;

    boolean hasToken(String accessToken);

    void register(String email, String pass);


}
