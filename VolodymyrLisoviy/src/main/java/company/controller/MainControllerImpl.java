package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.Date;
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

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return find(predicate::filter, appDb.getAll()).stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Employee fireWorker(int workerId) {
        Employee employee = appDb.remove(workerId);
        if (employee != null)
            employee.setEndWorkDate(new Date());
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return appDb.update(worker);
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        Employee e1 = appDb.getById(emp1id);
        Employee e2 = appDb.getById(eml2id);
        return e1 != null && e2 != null && e1.equals(e2);
    }

    private List<Employee> find(Predicate<Employee> predicate, List<Employee> employeeList) {
        return employeeList.stream().filter(predicate).collect(Collectors.toList());
    }
}
