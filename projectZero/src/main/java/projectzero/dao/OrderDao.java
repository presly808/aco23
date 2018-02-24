package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.model.Order;

import java.util.List;

public class OrderDao implements IDao<Integer, Order> {

    public List<Order> getAll() {
        return null;
    }

    public List<Order> getAllByUser() {
        return null;
    }

    @Override
    public Order getById(Integer id) {
        return null;
    }


    /**
     * Add new order to db
     *
     * @param order - new user
     * @throws AlreadyExistsException if current order is already in db
     */
    @Override
    public void add(Order order) throws AlreadyExistsException {

    }

    /**
     * Remove order from db
     *
     * @param order - order to remove
     * @return true/false
     */
    @Override
    public boolean remove(Order order) {
        return false;
    }

    /**
     * Update user in db
     *
     * @param newOrder - new user
     * @return user before update
     */
    @Override
    public Order update(Order newOrder) {
        return null;
    }

}
