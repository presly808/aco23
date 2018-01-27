package company.controller;

import company.model.Employee;
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
        long start = getTime();
        Employee emp1 = mainController.addEmployee(employee);
        long end = getTime();
        log("addEmployee ", start, end);

        return emp1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public int calculateSalary(Employee employee) {
        return 0;
    }

    @Override
    public int calculateSalaries() {
        return 0;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        return null;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return null;
    }

    @Override
    public Employee fireWorker(int workerId) {
        return null;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return false;
    }
}
