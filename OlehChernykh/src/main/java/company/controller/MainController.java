package company.controller;

import company.model.Employee;
import company.notifier.MyListener;
import company.notifier.Observable;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public interface MainController extends Observable {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    int calculateSalary(Employee employee);

    int calculateSalaries();

    Employee getById(int id);

    List<Employee> findWithFilter(String name);

    List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator);

    Employee fireWorker(int workerId);

    Employee updateWorker(Employee worker);

    boolean areWorkersEqual(int emp1id, int eml2id);

    void addListener(MyListener listener);
}
