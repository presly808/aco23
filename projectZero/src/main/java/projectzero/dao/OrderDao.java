package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.exceptions.NoSuchElementException;
import projectzero.model.Order;
import projectzero.model.User;

import java.util.List;

public class OrderDao implements IDao<Integer, Order> {

    @Override
    public List<Order> getAll() {
        return null;
    }

    public List<Order> getAllByUser(User user) {
        return null;
    }

    @Override
    public Order getById(Integer id) throws NoSuchElementException {
        return null;
    }

    @Override
    public void add(Order newEntity) throws AlreadyExistsException {

    }

    @Override
    public boolean remove(Order order) {
        return false;
    }

    @Override
    public Order update(Order order) throws NoSuchElementException {
        return null;
    }
}
