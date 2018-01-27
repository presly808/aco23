package company.controller;

import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProfilingMainController implements MainController {

    private MainController mainController;

    private long start;
    private long end;

    public ProfilingMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        start();
        Employee employee1 = mainController.addEmployee(employee);
        end();
        log("addEmployee");
        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        start();
        List<Employee> list = mainController.getAllEmployees();
        end();
        log("getAllEmployees");
        return list;
    }

    @Override
    public int calculateSalary(Employee employee) {
        start();
        int salary = mainController.calculateSalary(employee);
        end();
        log("calculateSalary");
        return salary;
    }

    @Override
    public int calculateSalaries() {
        start();
        int salary = mainController.calculateSalaries();
        end();
        log("calculateSalaries");
        return salary;
    }

    @Override
    public Employee getById(int id) {
        start();
        Employee employee = mainController.getById(id);
        end();
        log("getById");
        return employee;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        start();
        List<Employee> list = mainController.findWithFilter(name);
        end();
        log("findWithFilter");
        return list;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        start();
        List<Employee> list = mainController.filterWithPredicate(predicate, comparator);
        end();
        log("filterWithPredicate");
        return list;
    }

    @Override
    public Employee fireWorker(int workerId) {
        start();
        Employee employee = mainController.fireWorker(workerId);
        end();
        log("fireWorker");
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        start();
        Employee employee = mainController.updateWorker(worker);
        end();
        log("updateWorker");
        return employee;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        start();
        boolean areEquals = mainController.areWorkersEqual(emp1id, eml2id);
        end();
        log("areWorkersEquals");
        return areEquals;
    }

    private void start() {
        start = System.nanoTime();
    }

    private void end() {
        end = System.nanoTime();
    }

    private void log(String methodName) {
        System.out.printf("%s - time = %dns%n", methodName, end - start);
    }
}
