package company.controller;

import company.notifier.MyEvent;
import company.utils.MyValidator;
import company.db.AppDb;
import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;
import company.utils.reflection.ReflectionUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 20.01.18.
 */
public class MainControllerImpl implements MainController {

    private AppDb appDb;
    private MyValidator validator;
    private List<MyListener> listeners;

    public MainControllerImpl(AppDb appDb) {
        this.appDb = appDb;
        this.validator = new MyValidator();
        this.listeners = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        boolean validated = validator.validate(employee);
        if (!validated) {
            System.err.println("Employee was not valid");
            return null;
        }
        return appDb.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(appDb.getAll());
    }


    @Override
    public int calculateSalary(Employee employee) {
        Employee found = appDb.getById(employee.getId());
        if (found == null) {
            System.err.println("employee with " + employee.getId() + " not found");
            return 0;
        }

        return found.calculateSalary();
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
        Stream<Employee> stream = appDb.getAll().stream();

        return stream.filter((employee) -> employee.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return appDb.getAll().stream().filter(predicate::filter).sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Employee fireWorker(int workerId) {
        callListener();
        return appDb.remove(workerId);
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return null;
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return appDb.getById(emp1id).equals(appDb.getById(eml2id));
    }

    @Override
    public void addListener(MyListener myListener) {
        this.listeners.add(myListener);
    }

    @Override
    public void callListener() {
        MyEvent obj = new MyEvent(new Date(), this.getClass().getName() + "." + ReflectionUtils.getMethodName(3), "some info");
        for (MyListener listener : listeners) {
            listener.eventOccur(obj);
        }
    }
}
