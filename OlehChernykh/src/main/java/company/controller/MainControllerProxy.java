package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class MainControllerProxy implements MainController {

    private MainController mainController;

    public MainControllerProxy(MainControllerImpl mainController) {
        this.mainController = mainController;
    }

    @Override
    public Employee addEmployee (Employee employee) {
        long startTime = System.nanoTime();
        Employee employee1 = mainController.addEmployee(employee);
        long endTime = System.nanoTime();
        System.out.println ("addEmployee execution time is " + (endTime - startTime));
        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        long startTime = System.nanoTime();
        List<Employee> employeeList = mainController.getAllEmployees();
        long endTime = System.nanoTime();
        System.out.println ("getAllEmployees execution time is " + (endTime -startTime));
        return employeeList;
    }

    @Override
    public int calculateSalary(Employee employee) {
        long startTime = System.nanoTime();
        int salary = mainController.calculateSalary(employee);
        long endTime = System.nanoTime();
        System.out.println ("calculateSalary execution time is " + (endTime - startTime));
        return salary;
    }

    @Override
    public int calculateSalaries() {
        long startTime = System.nanoTime();
        int salaries = mainController.calculateSalaries();
        long endTime = System.nanoTime();
        System.out.println ("calculateSalaries execution time is " + (endTime - startTime));
        return salaries;
    }

    @Override
    public Employee getById(int id) {
        long startTime = System.nanoTime();
        Employee employee = mainController.getById(id);
        long endTime = System.nanoTime();
        System.out.println ("getById execution time is " + (endTime - startTime));
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        long startTime = System.nanoTime();
        List<Employee> employees = mainController.findWithFilter(name);
        long endTime = System.nanoTime();
        System.out.println ("findWithFilter execution time is " + (endTime - startTime));
        return employees;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        long startTime = System.nanoTime();
        List<Employee> employees = mainController.filterWithPredicate(predicate,comparator);
        long endTime = System.nanoTime();
        System.out.println ("filterWithPredicate execution time is " + (endTime - startTime));
        return employees;
    }

    @Override
    public Employee fireWorker(int workerId) {
        long startTime = System.nanoTime();
        Employee employee = mainController.fireWorker(workerId);
        long endTime = System.nanoTime();
        System.out.println ("fireWorker execution time is " + (endTime - startTime));
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        long startTime = System.nanoTime();
        Employee employee = mainController.updateWorker(worker);
        long endTime = System.nanoTime();
        System.out.println ("updateWorker execution time is " + (endTime - startTime));
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        long startTime = System.nanoTime();
        boolean isWorkerEqual = mainController.areWorkersEqual(emp1id,eml2id);
        long endTime = System.nanoTime();
        System.out.println ("areWorkersEqual execution time is " + (endTime - startTime));
        return isWorkerEqual;
    }

    @Override
    public void addListener(MyListener listener) {
        long startTime = System.nanoTime();
        mainController.addListener(listener);
        long endTime = System.nanoTime();
        System.out.println ("addListener execution time is " + (endTime - startTime));


    }

    @Override
    public void callListener() {
        long startTime = System.nanoTime();
        mainController.callListener();
        long endTime = System.nanoTime();
        System.out.println ("callListener execution time is " + (endTime - startTime));

    }

}
