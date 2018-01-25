package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.model.Manager;
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
        return appDb.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return appDb.getAll();
    }

    @Override
    public int calculateSalary(Employee employee) {
        return employee.getSalary();
    }

    @Override
    public int calculateSalaries() {
        List<Employee> employees = getAllEmployees();

        int sum = 0;

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            sum += emp.getSalary();

            if (emp instanceof Manager) {
                Manager manager = (Manager) emp;
                List<Employee> subworkers = manager.getSubworkers();

                for (int j = 0; j < subworkers.size(); j++) {
                    sum += 0.05 * subworkers.get(j).getSalary();
                }
            }
        }

        return sum;
    }

    @Override
    public Employee getById(int id) {
        return appDb.getById(id);
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        // getall()
        // List<Employee> filtered = new ArrayList<>()
        // ...equals ignore case - add to list
        // return list
        return null;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> allEmployees = getAllEmployees();

        List<Employee> result = new ArrayList<>();
        for (int i = 1; i < allEmployees.size(); i++) {
            Employee emp = allEmployees.get(i);

            if(!predicate.filter(emp)) {
                result.add(emp);
            }
        }

        result.sort(comparator);

        return result;
    }

    @Override
    public Employee fireWorker(int workerId) {
        return appDb.remove(workerId);
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        Employee emp1 = getById(emp1id);
        Employee emp2 = getById(eml2id);

        return emp1.getName().equals(emp2.getName());
    }
}
