package company.db;

import company.model.Employee;
import company.model.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public class AppDb {

    private ArrayList<Employee> employees;

    public AppDb(){
        this.employees = new ArrayList<>();
    }

    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAll(){
        return employees;
    }

    public Employee remove(int id) {
        Employee employee = null;
        for (Employee em : employees) {
            if (em.getId() == id) {
                employee = em;
                break;
            }
        }
        employees.remove(employee);

        return employee;
    }

    public Employee getById(int id){
        for (Employee em: employees)
            if (em.getId() == id)
                return em;
        return null;
    }

}
