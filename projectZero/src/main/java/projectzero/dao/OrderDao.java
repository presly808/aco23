package projectzero.dao;

import projectzero.exceptions.AlreadyExistsException;
import projectzero.exceptions.NoSuchElementException;
import projectzero.model.Order;
import projectzero.model.User;
import projectzero.utils.JSONUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDao implements IDao<Integer, Order> {

    private String pathToJson;

    public OrderDao(String pathToJson) {
        this.pathToJson = pathToJson;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try {
            orders.addAll(JSONUtils.readAllFromFile(pathToJson, Order.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getAllByUser(User user) {
        return this.getAll().stream()
                .filter(order -> order.getOwner().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public Order getById(Integer id) throws NoSuchElementException {
        List<Order> orders = this.getAll();
        for (Order order : orders){
            if (id.equals(order.getId())){
                return order;
            }
        }
        throw  new NoSuchElementException();
    }

    @Override
    public void add(Order newEntity) throws AlreadyExistsException {
        List<Order> orders = this.getAll();
        for (Order order : orders){
            if (order.equals(newEntity)){
                throw new AlreadyExistsException("Order already exist");
            }
        }
        orders.add(newEntity);
        JSONUtils.writeListIntoFile(pathToJson, orders);
    }

    @Override
    public boolean remove(Order order) {
        List<Order> orders = this.getAll();

        int index = orders.indexOf(order);

        if (index < 0)
            return false;
        orders.remove(index);
        JSONUtils.writeListIntoFile(pathToJson, orders);
        return true;
    }

    @Override
    public Order update(Order order) throws NoSuchElementException {
        List<Order> orders = this.getAll();

        int index = orders.indexOf(order);

        if (index < 0)
            throw  new NoSuchElementException();
        Order result = orders.set(index, order);
        JSONUtils.writeListIntoFile(pathToJson, orders);
        return result;
    }
}
