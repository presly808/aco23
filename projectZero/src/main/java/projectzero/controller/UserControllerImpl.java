package projectzero.controller;

import projectzero.model.Order;
import projectzero.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class UserControllerImpl implements IUserController {

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String register(String email, String pass) {
        return null;
    }

    @Override
    public List<Order> getAll(User user) {
        return null;
    }

    @Override
    public List<Order> getAllSortedBy(User user, Comparator<Order> comparator) {
        return null;
    }

    @Override
    public List<Order> getFilteredBy(User user, Predicate<Order> predicate) {
        return null;
    }
}
