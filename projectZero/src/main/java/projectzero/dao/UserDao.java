package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.User;

import java.util.List;

public class UserDao {


    /**
     * @return list of all users
     */
    public List<User> getAll() {
        return null;
    }

    /**
     * @param email - user's email
     * @return user with such email
     */
    public User getByEmail(String email) {
        return null;
    }

    /**
     * Add new user to db
     * @param user - new user
     * @throws AlreadyExistsException if current user is already in db
     */
    public void add(User user) throws AlreadyExistsException{

    }

    /**
     * Remove user from db
     * @param user - user to remove
     * @return true/false
     */
    public boolean remove(User user) {
        return false;
    }

    /**
     * Update user in db
     * @param newUser - new user
     * @return user before update
     */
    public User update(User newUser) {
        return null;
    }
}
