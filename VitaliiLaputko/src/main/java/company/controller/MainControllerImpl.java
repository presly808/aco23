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
import java.util.stream.Collectors;

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
        int salary = employee.calculateSalary();
        System.out.println(employee.getName() + " salary => " + salary);

        return salary;
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    @Override
    public int calculateSalaries() {
        int salaries = 0;

        for (Employee employee: appDb.getAll())
            salaries += calculateSalary(employee);

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

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return appDb.getAll().stream().filter(predicate::filter)
                .sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Employee fireWorker(int workerId) {
        Employee fireEmployee = appDb.getById(workerId);

        if (fireEmployee != null) {
            for (int i = 0; i < appDb.getAll().size(); i++) {
                if (appDb.getAll().get(i).equals(fireEmployee)) appDb.remove(i);
            }
        }

        return fireEmployee;
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return appDb.update(worker);
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return appDb.getById(emp1id).equals(appDb.getById(eml2id));
    }

    @Override
    public void addListener(MyListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void callListener() {
        MyEvent obj = new MyEvent(new Date(), this.getClass().getName() + "." + ReflectionUtils.getMethodName(3), "some info");
        for (MyListener listener : listeners) {
            listener.eventOccur(obj);
        }
    }
}
