package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.ArrayList;
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
        int salaries = 0;
        for (Employee empl: appDb.getAll()){
            salaries += empl.calculateSalary();
        }
        return salaries;
    }

    @Override
    public Employee getById(int id) {
        return appDb.getById(id);
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee empl: appDb.getAll()) {
            if(empl.getName().toLowerCase().contains(name)){
                result.add(empl);
            }
        }
        return result;
    }


    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : appDb.getAll()) {
            if (predicate.filter(employee)) {
                result.add(employee);
            }
        }
        result.sort(comparator);
        return result;
    }

    @Override
    public Employee fireWorker(int workerId) {
        for (Employee employee : appDb.getAll()) {
            if (employee.getId() == workerId){
                appDb.getAll().remove(employee);
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return appDb.getById(emp1id).equals(appDb.getById(eml2id));
    }
}
