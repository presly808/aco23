package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.User;
import projectzero.utils.JSONUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements IDao<String, User> {

    private String pathToJson;

    public UserDao(String pathToJson) {
        this.pathToJson = pathToJson;
    }

    /**
     * @return list of all users
     */
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            list = JSONUtils.readUsersFromFile(pathToJson);
        } catch (IOException e) {
            // TODO: 24-Feb-18 logger
        }
        return list;
    }

    /**
     * @param email - user's email
     * @return user with such email or null if user with current email doesn't exists
     */
    @Override
    public User getById(String email) {
        List<User> list = this.getAll();
        for (User user : list)
            if (user.getEmail().equals(email))
                return user;
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
        List<User> userList = this.getAll();

        if (userList.contains(user))
            throw new AlreadyExistsException("User already exists");

        try {
            JSONUtils.addUser(pathToJson, user);
        } catch (IOException e) {
            // TODO: 24-Feb-18 logger
            // exception handling
        }
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
