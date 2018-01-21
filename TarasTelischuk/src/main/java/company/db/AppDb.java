package company.db;

import company.model.Employee;

import java.util.ArrayList;
import java.util.List;

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

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAll(){
        return employees;
    }

    public Employee remove(int id){
        Employee employee = null;
        for (Employee emp: employees){
            if (emp.getId() == id) {
                employee = emp;
                break;
            }
        }
        employees.remove(employee);
        return employee;
    }

    public Employee getById(int id) {
        for (Employee i : employees) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

}
