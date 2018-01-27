package company.controller;

import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class MainControllerProxy implements MainController {

    private MainControllerImpl mainController;


    @Override
    public Employee addEmployee(Employee employee) {
        long startTime = System.nanoTime();
        Employee employee1 = mainController.addEmployee(employee);
        long endTime = System.nanoTime();
        System.out.println(endTime -startTime);
        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        long startTime = System.nanoTime();
        List<Employee> employeeList = mainController.getAllEmployees();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employeeList;
    }

    @Override
    public int calculateSalary(Employee employee) {
        long startTime = System.nanoTime();
        int salary = mainController.calculateSalary(employee);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return salary;
    }

    @Override
    public int calculateSalaries() {
        long startTime = System.nanoTime();
        int salaries = mainController.calculateSalaries();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return salaries;
    }

    @Override
    public Employee getById(int id) {
        long startTime = System.nanoTime();
        Employee employee = mainController.getById(id);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        long startTime = System.nanoTime();
        List<Employee> employees = mainController.findWithFilter(name);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employees;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        long startTime = System.nanoTime();
        List<Employee> employees = mainController.filterWithPredicate(predicate,comparator);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employees;
    }

    @Override
    public Employee fireWorker(int workerId) {
        long startTime = System.nanoTime();
        Employee employee = mainController.fireWorker(workerId);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        long startTime = System.nanoTime();
        Employee employee = mainController.updateWorker(worker);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        long startTime = System.nanoTime();
        boolean isWorkerEqual = mainController.areWorkersEqual(emp1id,eml2id);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return isWorkerEqual;
    }
}
