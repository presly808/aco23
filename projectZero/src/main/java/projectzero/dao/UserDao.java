package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.exceptions.NoSuchElementException;
import projectzero.model.User;
import projectzero.utils.JSONUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IDao<String, User> {

    private String pathToJson;

    public UserDao(String pathToJson) {
        this.pathToJson = pathToJson;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            users.addAll(JSONUtils.readAllFromFile(pathToJson, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(String id) throws NoSuchElementException {
        return this.getAll().stream()
                .filter(item -> item.getEmail().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void add(User newEntity) throws AlreadyExistsException {
        List<User> userList = this.getAll();
        for (User user : userList)
            if (user.equals(newEntity))
                throw new AlreadyExistsException("User already exists");
        userList.add(newEntity);
        JSONUtils.writeListIntoFile(pathToJson, userList);
    }

    @Override
    public boolean remove(User user) {
        List<User> userList = this.getAll();

        int index = userList.indexOf(user);

        if (index < 0)
            return false;
        userList.remove(index);
        JSONUtils.writeListIntoFile(pathToJson, userList);
        return true;
    }

    @Override
    public User update(User user) throws NoSuchElementException {
        List<User> userList = this.getAll();

        int index = userList.indexOf(user);

        if (index < 0)
            throw  new NoSuchElementException();
        User result = userList.set(index, user);
        JSONUtils.writeListIntoFile(pathToJson, userList);
        return result;
    }
}
