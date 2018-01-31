package company.proxy;

import company.controller.MainController;
import company.model.Employee;
import company.notifier.MyListener;
import company.utils.MyAction;
import company.utils.filtering.EmployeePredicate;
import company.utils.logger.LogContainer;
import company.utils.logger.LogEvent;
import company.utils.reflection.ReflectionUtils;

import java.util.Comparator;
import java.util.List;

public class MainControllerProxy implements MainController {

    private MainController mainController;
    private LogContainer logContainer;

    public MainControllerProxy(MainController mainController) {
        this.mainController = mainController;
        this.logContainer = new LogContainer();
    }

    private Object countTime(MyAction action) {
        long start = System.currentTimeMillis();

        Object ret = action.invoke();

        long end = System.currentTimeMillis();
        long res = end - start;
        int parent_method_index_stack = 3;
        String place = ReflectionUtils.getMethodName(parent_method_index_stack);
        System.out.println(place + " work time: " + res);
        logContainer.saveLog(new LogEvent(
                place,
                res));
        return ret;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) countTime(() -> mainController.getAllEmployees());
    }

    @Override
    public int calculateSalary(Employee employee) {
        return (Integer) countTime(() -> mainController.calculateSalary(employee));
    }

    @Override
    public int calculateSalaries() {
        return (Integer) countTime(() -> mainController.calculateSalaries());
    }

    @Override
    public Employee getById(int id) {
        return (Employee) countTime(() -> mainController.getById(id));
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        return (List<Employee>) countTime(() -> mainController.findWithFilter(name));
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return (List<Employee>) countTime(() -> mainController.filterWithPredicate(predicate, comparator));
    }

    @Override
    public Employee fireWorker(int workerId) {
        return (Employee) countTime(() -> mainController.fireWorker(workerId));
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {

        return (Boolean) countTime(() -> mainController.areWorkersEqual(emp1id, eml2id));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        mainController.addEmployee(employee);
        return employee;

        //return (Employee) countTime(() -> mainController.addEmployee(employee));
    }

    @Override
    public void addListener(MyListener myListener) {
        long start = System.currentTimeMillis();
        mainController.addListener(myListener);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " addListener() time");
    }


    @Override
    public void callListener() {
        long start = System.currentTimeMillis();
        mainController.callListener();
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " callListener() time");
    }
}
