package company.controller;

import company.db.AppDb;
import company.model.Employee;

import java.util.ArrayList;
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
        return appDb.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return appDb.getAll();
    }

    @Override
    public int calculateSalary(Employee employee) {
        int salary = employee.getSalary();
        System.out.println(employee.getName() + " salary => " + salary);

        return salary;
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    @Override
    public int calculateSalaries() {
        int salaries = 0;

        for (Employee employee: appDb.getAll()) {
            salaries += employee.getSalary();
        }

        return salaries;
    }

    @Override
    public Employee getById(int id) {
        return appDb.getById(id);
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee: appDb.getAll()) {
            if (employee.getName().toLowerCase().contains(name)) {
                list.add(employee);
            }
        }

        return list;
    }
}
