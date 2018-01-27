package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public class MainControllerImpl implements MainController {

    private AppDb appDb;

    public MainControllerImpl(AppDb appDb) {
        this.appDb = appDb;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        appDb.getWorkersList().add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return appDb.getWorkersList();
    }

    @Override
    public int calculateSalary(Employee employee) {
        return employee.getSalary();
    }

    @Override
    public int calculateSalaries() {
        int allSalaries = 0;
        for (Employee employee : appDb.getWorkersList()) {
            allSalaries += employee.getSalary();
        }
        return allSalaries;
    }

    @Override
    public Employee getById(int id) {
        for (Employee employee : appDb.getWorkersList()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : appDb.getWorkersList()) {
            if ((employee.getName().toLowerCase()).contains(name.toLowerCase())) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : appDb.getWorkersList()) {
            if (predicate.filter(employee)) {
                result.add(employee);
            }
        }
        result.sort(comparator);
        return result;
    }

    @Override
    public Employee fireWorker(int workerId) {
        for (Employee employee : appDb.getWorkersList()) {
            if (employee.getId() == workerId) {
                appDb.getWorkersList().remove(employee);
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return emp1id == eml2id;
    }
}
