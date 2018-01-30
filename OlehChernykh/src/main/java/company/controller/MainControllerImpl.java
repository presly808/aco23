package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.notifier.MyEvent;
import company.notifier.MyListener;
import company.utils.MyUtils;
import company.utils.filtering.EmployeePredicate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *  Created by serhii on 20.01.18.
 */
public class MainControllerImpl implements MainController, EmployeePredicate {

    private AppDb appDb;
    private List<MyListener> listeners;

    public MainControllerImpl(AppDb appDb) {
        this.appDb = appDb;
        this.listeners = new ArrayList<>();
    }

    public List<MyListener> getListeners() {
        return listeners;
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
        return employee.calculatesalary();
    }

    @Override
    public int calculateSalaries() {
        return 100 + appDb.getAll().stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Employee getById(int id) {
        return appDb.getById(id);
    }

    @Override
    public List<Employee> findWithFilter(String name) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee em: appDb.getAll()) {
            if (em.getName().toLowerCase().contains(name.toLowerCase())){
                employeeList.add(em);
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee e: appDb.getAll()){
            if (predicate.filter(e)) employeeList.add(e);
        }

        return employeeList;
    }

    @Override
    public Employee fireWorker(int workerId) {
        callListener();
        Employee employee = appDb.getById(workerId);
        if (employee != null)
            employee.setEndWorkDate(new Date());
        return employee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        Employee employee1 = appDb.getById(emp1id);
        Employee employee2 = appDb.getById(eml2id);
        return employee1 != null && employee2 != null
                && employee1.equals(employee2);
    }


    @Override
    public boolean filter(Employee employee) {
        for (Employee em: appDb.getAll()) {
            if (em.getSalary() < 3000) return true;
        }
        return false;
    }


    @Override
    public void addListener(MyListener listener) {
        this.listeners.add(listener);

    }


    @Override
    public void callListener() {
        for (MyListener listener: listeners) {
            listener.eventOccur(new MyEvent(new Date(),this.getClass().getName() + "."
                    + MyUtils.getMethodName(3),null));
        }

    }


}
