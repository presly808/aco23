package proxy;

import controller.MainController;
import exceptions.AppException;
import exceptions.UserNotFoundException;
import model.Order;
import model.OrderStatus;
import model.User;
import utils.ReflectionUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class MainControllerProxy implements MainController {

    private MainController mainController;
    private LogContainer logContainer;

    public MainControllerProxy(MainController mainController) {
        this.mainController = mainController;
        this.logContainer = new LogContainer();
    }

    private Object saveLog(MyAction action) throws AppException, IOException {
        Object ret = action.invoke();
        int parent_method_index_stack = 3;
        String place = ReflectionUtils.getMethodName(parent_method_index_stack);
        logContainer.saveLog(new LogEvent(place));
        return ret;
    }


    @Override
    public Map<String, User> getAllUsers() throws AppException, IOException {
        return (Map<String, User>) saveLog(mainController::getAllUsers);
    }

    @Override
    public Map<Integer, Order> getAllOrders() throws AppException, IOException {
        return (Map<Integer, Order>) saveLog(mainController::getAllOrders);
    }

    @Override
    public User getById(int id) throws AppException, UserNotFoundException, IOException {
        return (User) saveLog(() -> mainController.getById(id));
    }

    @Override
    public Order getOrderbyId(int id) throws AppException, IOException {
        return (Order) saveLog(() -> mainController.getOrderbyId(id));
    }


    @Override
    public Map<Integer, User> filterByName(String name) throws AppException, IOException {
        return (Map<Integer, User>) saveLog(() -> mainController.filterByName(name));
    }

    @Override
    public Map<Integer, User> filterByCity(String city) throws AppException, IOException {
        return (Map<Integer, User>) saveLog(()->mainController.filterByCity(city));
    }

    @Override
    public Map<Integer, User> filterByReciever(String receiverName) throws AppException, IOException {
        return (Map<Integer, User>) saveLog(()-> mainController.filterByReciever(receiverName));
    }

    @Override
    public Map<Integer, User> filterByDate(LocalDateTime dateTime) throws AppException, IOException {
        return (Map<Integer, User>) saveLog(()-> mainController.filterByDate(dateTime));
    }

    @Override
    public String changeOrderStatus(Order order, OrderStatus orderStatus, String accessToken) throws AppException, IOException {
        return (String) saveLog(() -> mainController.changeOrderStatus(order, orderStatus, accessToken));
    }
}
