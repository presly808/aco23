package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.notifier.MyEvent;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;
import company.utils.reflection.Reflection;

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
      /*  for (Employee employee : appDb.getAll()) {
            if (employee.getId() == workerId){
                appDb.getAll().remove(employee);
                return employee;
            }
        }
        return null;*/
      callListener();
      return appDb.remove(workerId);
    }

    @Override
    public Employee updateWorker(Employee worker) {
        return appDb.update(worker);
    }

    @Override
    public boolean areWorkersEqual(int emp1id, int eml2id) {
        Employee emp1 = appDb.getById(emp1id);
        Employee emp2 = appDb.getById(eml2id);
        return emp1 != null && emp2 != null && emp1.equals(emp2);
    }

    @Override
    public void addListener(MyListener myListener) {
        listeners.add(myListener);
    }

    @Override
    public void callListener() {
        MyEvent obj = new MyEvent(new Date(), this.getClass().getName() + "." + Reflection.getMethodName(3), "some info");
        for (MyListener listener : listeners) {
            listener.eventOccur(obj);
        }
    }

}
