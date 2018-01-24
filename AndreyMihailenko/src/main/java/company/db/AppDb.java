package company.db;

import company.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by serhii on 20.01.18.
 */
public class AppDb {

    private List<Employee> employees;

    public AppDb() {
        this.employees = new ArrayList<>();
    }

    public AppDb(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAll(){
        return employees;
    }

    public Employee remove(int id){
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (employee1.getId() == id){
                employee = employee1;
                break;
            }
        }
        employees.remove(employee);
        return employee;
    }

    public Employee getById(int id){
        for (Employee employee : employees){
            if (employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    public Employee update(Employee worker) {
        ListIterator<Employee> iterator = employees.listIterator();
        Employee employee = null;
        while (iterator.hasNext()){
            if ((employee = iterator.next()).equals(worker)){
                iterator.set(worker);
                break;
            }
        }
        return employee;
    }
}
