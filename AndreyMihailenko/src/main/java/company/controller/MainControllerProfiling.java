package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class MainControllerProfiling implements MainController {

    private MainController mainController;

    private long start;
    private long end;

    public MainControllerProfiling(MainController mainController) {
        this.mainController = mainController;
    }

    public void start() {
        start = System.nanoTime();
    }

    public void end() {
        end = System.nanoTime();
    }

    public void message(String methodName) {
        System.out.printf("%s method time = %s (ns)\n", methodName, end - start);
    }


    @Override
    public Employee addEmployee(Employee employee) {
        start();
        Employee employee1 = mainController.addEmployee(employee);
        end();
        message("addEmployee");
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        start();
        List<Employee> employeeList = mainController.getAllEmployees();
        end();
        message("getAllEmployees");
        return employeeList;
    }

    @Override
    public int calculateSalary(Employee employee) {
        start();
        int salary = mainController.calculateSalary(employee);
        end();
        message("calculateSalary");
        return salary;
    }

    @Override
    public int calculateSalaries() {
        start();
        int salarys = mainController.calculateSalaries();
        end();
        message("calculateSalaries");
        return salarys;
    }

    @Override
    public Employee getById(int id) {
        start();
        Employee employee = mainController.getById(id);
        end();
        message("getById");
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        start();
        List<Employee> employeeList = mainController.findWithFilter(name);
        end();
        message("findWithFilter");
        return employeeList;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        start();
        List<Employee> employeeList = mainController.filterWithPredicate(predicate, comparator);
        end();
        message("filterWithPredicate");
        return employeeList;
    }

    @Override
    public Employee fireWorker(int workerId) {
        start();
        Employee employee = mainController.fireWorker(workerId);
        end();
        message("fireWorker");
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        start();
        Employee employee = mainController.updateWorker(worker);
        end();
        message("updateWorker");
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        start();
        boolean equals = mainController.areWorkersEqual(emp1id, eml2id);
        end();
        message("areWorkersEqual");
        return equals;
    }

    @Override
    public void addListener(MyListener myListener) {
        start();
        mainController.addListener(myListener);
        end();
        message("addListener");
    }
}
