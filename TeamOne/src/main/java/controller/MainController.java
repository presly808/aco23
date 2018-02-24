package controller;

import model.User;
import model.UserPredicate;

import java.util.Comparator;
import java.util.List;

public interface MainController {

    User addUser(User User);

    List<User> getAllUsers();

    User getById(int id);

    List<User> findWithFilter(String name);

    List<User> filterWithPredicate(UserPredicate predicate, Comparator<User> comparator);

    User fireWorker(int workerId);

    User updateWorker(User worker);

    boolean areWorkersEqual(int emp1id, int eml2id);

    void addListener(MyListener listener);
}
