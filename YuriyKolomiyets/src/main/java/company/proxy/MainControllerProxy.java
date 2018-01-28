package company.proxy;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class MainControllerProxy implements MainController {

    private MainControllerImpl mainControllerImpl;

    public MainControllerProxy(MainControllerImpl mainControllerImpl) {
        this.mainControllerImpl = mainControllerImpl;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        long start = System.currentTimeMillis();
        mainControllerImpl.addEmployee(employee);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " addEmployee time");

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        long start = System.currentTimeMillis();
        List<Employee> allEmployees = mainControllerImpl.getAllEmployees();
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " getAllEmployees time");

        return allEmployees;
    }

    @Override
    public int calculateSalary(Employee employee) {
        long start = System.currentTimeMillis();
        int salary = mainControllerImpl.calculateSalary(employee);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " calculateSalary time");

        return salary;
    }

    @Override
    public int calculateSalaries() {
        long start = System.currentTimeMillis();
        int salary = mainControllerImpl.calculateSalaries();
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " calculateSalaries() time");

        return salary;
    }

    @Override
    public Employee getById(int id) {
        long start = System.currentTimeMillis();
        Employee employee = mainControllerImpl.getById(id);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " getById() time");

        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        long start = System.currentTimeMillis();
        List<Employee> filteredList = mainControllerImpl.findWithFilter(name);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " findWithFilter() time");

        return filteredList;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        long start = System.currentTimeMillis();
        List<Employee> filteredList = mainControllerImpl.filterWithPredicate(predicate, comparator);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " filterWithPredicate() time");

        return filteredList;
    }

    @Override
    public Employee fireWorker(int workerId) {
        long start = System.currentTimeMillis();
        Employee firedEmployee = mainControllerImpl.fireWorker(workerId);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " fireWorker() time");

        return firedEmployee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        long start = System.currentTimeMillis();
        boolean areEqual = mainControllerImpl.areWorkersEqual(emp1id, eml2id);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " fireWorker() time");

        return areEqual;
    }

    @Override
    public void addListener(MyListener myListener) {
        long start = System.currentTimeMillis();
        mainControllerImpl.addListener(myListener);
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " addListener() time");
    }

    @Override
    public void callListener() {
        long start = System.currentTimeMillis();
        mainControllerImpl.callListener();
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println(res + " callListener() time");
    }
}
