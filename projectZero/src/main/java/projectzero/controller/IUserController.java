package projectzero.controller;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.Order;
import projectzero.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface IUserController {

    String login(User user);
    void join (String email, String pass) throws AlreadyExistsException;
    List<Order> getAll(User user);
    List<Order> getAllSortedBy(User user, Comparator<Order> comparator);
    List<Order> getFilteredBy(User user, Predicate<Order> predicate);

}
