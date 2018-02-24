package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.User;

import java.util.List;

public class UserDao implements IDao<String, User> {


    /**
     * @return list of all users
     */
    @Override
    public List<User> getAll() {
        return null;
    }

    /**
     * @param email - user's email
     * @return user with such email
     */
    @Override
    public User getById(String email) {
        return null;
    }

    /**
     * Add new user to db
     *
     * @param user - new user
     * @throws AlreadyExistsException if current user is already in db
     */
    @Override
    public void add(User user) throws AlreadyExistsException {

    }

    /**
     * Remove user from db
     *
     * @param user - user to remove
     * @return true/false
     */
    @Override
    public boolean remove(User user) {
        return false;
    }

    /**
     * Update user in db
     *
     * @param newUser - new user
     * @return user before update
     */
    @Override
    public User update(User newUser) {
        return null;
    }
}
