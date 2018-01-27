package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class ProfilingMainController implements MainController {

    private MainController mainController;


    public ProfilingMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        long start = getTime();
        Employee employee1 = mainController.addEmployee(employee);
        long end = getTime();
        log("addEmployee", start, end);
        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        long start = getTime();
        List<Employee> list = mainController.getAllEmployees();
        long end = getTime();
        log("getAllEmployees", start, end);
        return list;
    }

    @Override
    public int calculateSalary(Employee employee) {
        long start = getTime();
        int salary = mainController.calculateSalary(employee);
        long end = getTime();
        log("calculateSalary", start, end);
        return salary;
    }

    @Override
    public int calculateSalaries() {
        long start = getTime();
        int salary = mainController.calculateSalaries();
        long end = getTime();
        log("calculateSalaries", start, end);
        return salary;
    }

    @Override
    public Employee getById(int id) {
        long start = getTime();
        Employee employee = mainController.getById(id);
        long end = getTime();
        log("getById", start, end);
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        long start = getTime();
        List<Employee> list = mainController.findWithFilter(name);
        long end = getTime();
        log("findWithFilter", start, end);
        return list;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        long start = getTime();
        List<Employee> list = mainController.filterWithPredicate(predicate, comparator);
        long end = getTime();
        log("filterWithPredicate", start, end);
        return list;
    }

    @Override
    public Employee fireWorker(int workerId) {
        long start = getTime();
        Employee employee = mainController.fireWorker(workerId);
        long end = getTime();
        log("fireWorker", start, end);
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        long start = getTime();
        Employee employee = mainController.updateWorker(worker);
        long end = getTime();
        log("updateWorker", start, end);
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        long start = getTime();
        boolean areEquals = mainController.areWorkersEqual(emp1id, eml2id);
        long end = getTime();
        log("areWorkersEquals", start, end);
        return areEquals;
    }

    @Override
    public void addListener(MyListener myListener) {
        long start = getTime();
        mainController.addListener(myListener);
        long end = getTime();
        log("addListener", start, end);
    }

    @Override
    public void callListener() {
        long start = getTime();
        mainController.callListener();
        long end = getTime();
        log("callListener", start, end);
    }

    private long getTime() {
        return System.nanoTime();
    }

    private void log(String methodName, long start, long end) {
        System.out.printf("%s - time = %dns%n", methodName, end - start);
    }
}
