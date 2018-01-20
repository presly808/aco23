package company.controller;

import company.db.AppDb;
import company.model.Employee;

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
        return null;
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
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        return null;
    }
}
