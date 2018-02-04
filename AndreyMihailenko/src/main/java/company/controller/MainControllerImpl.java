package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.notifier.MyEvent;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;
import company.utils.reflection.ReflectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public class MainControllerImpl implements MainController {

    private AppDb appDb;
    private List<MyListener> listeners;

    public MainControllerImpl(AppDb appDb) {
        this.appDb = appDb;
        this.listeners = new ArrayList<>();
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
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : appDb.getAll()) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> arrayList = new ArrayList<>();
        for (Employee employee : appDb.getAll()) {
            if (predicate.filter(employee)) {
                arrayList.add(employee);
            }
        }
        arrayList.sort(comparator);
        return arrayList;
    }

    @Override
    public Employee fireWorker(int workerId) {
        callListener();
        for (Employee employee : appDb.getAll()) {
            if (employee.getId() == workerId){
                appDb.getAll().remove(employee);
                return  employee;
            }
        }
        return null;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return appDb.update(worker);
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int emp2id) {
        return appDb.getById(emp1id) != null && appDb.getById(emp2id) != null &&
                appDb.getById(emp1id).equals(appDb.getById(emp2id));
    }

    @Override
    public void addListener(MyListener myListener) {
        this.listeners.add(myListener);
    }

    @Override
    public void callListener() {
        MyEvent obj = new MyEvent(new Date(), this.getClass().getName()+ "." + ReflectionUtils.getMethodName(3), "some info");
        for (MyListener listener : listeners) {
            listener.eventOccur(obj);
        }
    }
}
