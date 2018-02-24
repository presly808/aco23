package projectzero.controller;

import projectzero.dao.UserDao;
import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.Order;
import projectzero.model.User;
import projectzero.utils.KeyUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class UserControllerImpl implements IUserController {

    private UserDao userDao;

    public UserControllerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String login(User user) {
        User loginUser = userDao.getById(user.getEmail());

        if (loginUser != null)
            return KeyUtils.getUniqueKey();

        return null;
    }

    @Override
    public void join(String email, String pass) throws AlreadyExistsException {
        userDao.add(new User(email, pass));
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
