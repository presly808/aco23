package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.utils.MyAction;
import company.utils.filtering.EmployeePredicate;
import company.utils.logger.LogContainer;
import company.utils.logger.LogEvent;
import company.utils.reflection.ReflectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainControllerProfilerProxy implements MainController {

    private MainController mainController;

    private LogContainer logContainer;

    public MainControllerProfilerProxy(MainController mainController) {
        this.mainController = mainController;
        this.logContainer = new LogContainer();
    }

    @Override
    public void callListener() {
        mainController.callListener();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return (Employee) countTime(() -> mainController.addEmployee(employee));
    }

    private Object countTime(MyAction action){
        long start = System.currentTimeMillis();

        Object ret = action.invoke();

        long end = System.currentTimeMillis();

        int parent_method_index_stack = 3;
        logContainer.saveLog(new LogEvent(
                this.getClass().getName() + "." +
                        ReflectionUtils.getMethodName(parent_method_index_stack),
                new Date(),
                "has been working for " + (end - start)));

        return ret;
    }

    @Override
    public Employee getById(int id) {
        return (Employee) countTime(() -> mainController.getById(id));
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
    public List<Employee> findWithFilter(String name) {
        return (List<Employee>) countTime(() -> mainController.findWithFilter(name));
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return (List<Employee>) countTime(() -> mainController.filterWithPredicate(predicate,comparator));
    }

    @Override
    public Employee fireWorker(int workerId) {
        return (Employee) countTime(() -> mainController.fireWorker(workerId));
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return (Boolean) countTime(()-> mainController.areWorkersEqual(emp1id,eml2id));
    }

    @Override
    public void addListener(MyListener myListener) {
        mainController.addListener(myListener);
    }
}
