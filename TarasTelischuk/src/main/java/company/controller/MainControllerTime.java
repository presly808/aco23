package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;
import java.util.Comparator;
import java.util.List;


public class MainControllerTime  implements MainController {

    private MainController mainController;

    public MainControllerTime(MainController mainController) {
        this.mainController = mainController;
    }


    @Override
    public Employee addEmployee(Employee employee) {
        long start = System.currentTimeMillis();
        Employee emp1 = mainController.addEmployee(employee);
        long end = System.currentTimeMillis();
        System.out.println("method 'addEmployee' time = " + (end - start));
        return emp1;
    }


    @Override
    public List<Employee> getAllEmployees() {
        long start = System.currentTimeMillis();
        List<Employee> list = mainController.getAllEmployees();
        long end = System.currentTimeMillis();
        System.out.println("method 'getAllEmployees' time = " + (end - start));
        return list;
    }

    @Override
    public int calculateSalary(Employee employee) {
        long start = System.currentTimeMillis();
        int salary = mainController.calculateSalary(employee);
        long end = System.currentTimeMillis();
        System.out.println("method 'calculateSalary' time = " + (end - start));
        return salary;
    }

    @Override
    public int calculateSalaries() {
        long start = System.currentTimeMillis();
        int salaries = mainController.calculateSalaries();
        long end = System.currentTimeMillis();
        System.out.println("method 'calculateSalaries' time = " + (end - start));
        return salaries;
    }

    @Override
    public Employee getById(int id) {
        long start = System.currentTimeMillis();
        Employee employee = mainController.getById(id);
        long end = System.currentTimeMillis();
        System.out.println("method 'getById' time = " + (end - start));
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        long start = System.currentTimeMillis();
        List<Employee> list = mainController.findWithFilter(name);
        long end = System.currentTimeMillis();
        System.out.println("method 'findWithFilter' time = " + (end - start));
        return list;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        long start = System.currentTimeMillis();
        List<Employee> list = mainController.filterWithPredicate(predicate, comparator);
        long end = System.currentTimeMillis();
        System.out.println("method 'filterWithPredicate' time = " + (end - start));
        return list;
    }

    @Override
    public Employee fireWorker(int workerId) {
        long start = System.currentTimeMillis();
        Employee employee = mainController.fireWorker(workerId);
        long end = System.currentTimeMillis();
        System.out.println("method 'fireWorker' time = " + (end - start));
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        long start = System.currentTimeMillis();
        Employee employee = mainController.updateWorker(worker);
        long end = System.currentTimeMillis();
        System.out.println("method 'updateWorker' time = " + (end - start));
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        long start = System.currentTimeMillis();
        boolean result = mainController.areWorkersEqual(emp1id, eml2id);
        long end = System.currentTimeMillis();
        System.out.println("method 'areWorkersEqual' time = " + (end - start));
        return result;
    }

    @Override
    public void addListener(MyListener myListener) {
        long start = System.currentTimeMillis();
        mainController.addListener(myListener);
        long end = System.currentTimeMillis();
        System.out.println("method 'addListener' time = " + (end - start));
    }

}
