package company.controller;

import company.model.Employee;

import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public interface MainController {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    int calculateSalary(Employee employee);

    int calculateSalaries();

    Employee getById(int id);

    List<Employee> findWithFilter(String name);

}
