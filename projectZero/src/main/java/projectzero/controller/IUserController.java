package projectzero.controller;

import projectzero.model.Order;
import projectzero.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface IUserController {

    List<Order> getAll(User user);
    List<Order> getAllSortedBy(User user, Comparator<Order> comparator);
    List<Order> getFilteredBy(User user, Predicate<Order> predicate);

}
