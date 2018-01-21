package company.controller;

import company.db.AppDb;
import company.model.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return appDb.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return appDb.getAll();
    }

    @Override
    public int calculateSalary(Employee employee) {
        return employee.calculateSalary();
    }

    @Override
    public int calculateSalaries() {
        return appDb.getAll().stream().mapToInt(Employee::calculateSalary).sum();
    }

    @Override
    public Employee getById(int id) {
        return appDb.getById(id);
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        return find(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()), appDb.getAll());
    }

    private List<Employee> find(Predicate<Employee> predicate, List<Employee> employeeList) {
        return employeeList.stream().filter(predicate).collect(Collectors.toList());
    }
}
