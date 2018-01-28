package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.notifier.MyEvent;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

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

    public List<MyListener> getListeners() {
        return listeners;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        appDb.getWorkersList().add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return appDb.getWorkersList();
    }

    @Override
    public int calculateSalary(Employee employee) {
        return employee.getSalary();
    }

    @Override
    public int calculateSalaries() {
        int allSalaries = 0;
        for (Employee employee : appDb.getWorkersList()) {
            allSalaries += employee.getSalary();
        }
        return allSalaries;
    }

    @Override
    public Employee getById(int id) {
        for (Employee employee : appDb.getWorkersList()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }


    @Override
    public List<Employee> findWithFilter(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : appDb.getWorkersList()) {
            if ((employee.getName().toLowerCase()).contains(name.toLowerCase())) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : appDb.getWorkersList()) {
            if (predicate.filter(employee)) {
                result.add(employee);
            }
        }
        result.sort(comparator);
        return result;
    }

    @Override
    public Employee fireWorker(int workerId) {
        for (Employee employee : appDb.getWorkersList()) {
            if (employee.getId() == workerId) {
                appDb.getWorkersList().remove(employee);
                callListener();
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return emp1id == eml2id;
    }

    @Override
    public void addListener(MyListener myListener) {
        listeners.add(myListener);
    }

    @Override
    public void callListener() {
        for (MyListener myListener:listeners) {
            myListener.eventOccur(new MyEvent(new Date(), getClass().getName().toString() + getMethodName().toString(),null ));
        }
    }

    public static String getMethodName() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.getStackTrace()[2].getMethodName();

        }
    }
}
