package projectzero.controller;

import projectzero.dao.OrderDao;
import projectzero.dao.UserDao;
import projectzero.exceptions.AlreadyExistsException;
import projectzero.exceptions.ApplicationException;
import projectzero.exceptions.NoSuchElementException;
import projectzero.model.Order;
import projectzero.model.User;
import projectzero.utils.KeyUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserControllerImpl implements IUserController {

    private UserDao userDao;
    private OrderDao orderDao;

    public UserControllerImpl(UserDao userDao, OrderDao orderDao) {
        this.userDao = userDao;
        this.orderDao = orderDao;
    }

    @Override
    public String login(User user) throws NoSuchElementException {
        User loginUser = userDao.getById(user.getEmail());

        if (loginUser == null)
            throw new NoSuchElementException();

        if (!loginUser.getPass().equals(user.getPass()))
            throw new NoSuchElementException("Wrong password");

        return KeyUtils.getUniqueKey();
    }

    @Override
    public void join(String email, String pass) throws AlreadyExistsException {
        userDao.add(new User(email, pass));
    }

    @Override
    public List<Order> getAll(User user) {
        return orderDao.getAllByUser(user);
    }

    @Override
    public List<Order> getAllSortedBy(User user, Comparator<Order> comparator) {
        List<Order> orders = orderDao.getAllByUser(user);
        orders.sort(comparator);
        return orders;
    }

    @Override
    public List<Order> getFilteredBy(User user, Predicate<Order> predicate) {
        return orderDao.getAllByUser(user).stream().filter(predicate).collect(Collectors.toList());
    }
}
