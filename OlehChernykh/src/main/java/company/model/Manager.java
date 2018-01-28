package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private ArrayList<Employee> employees;

    public Manager(String name, int salary) {
        super(name,salary);
        this.employees = new ArrayList<>();

    }

    public boolean addSubworker(Employee employee){
        if (employee != null) {
            return employees.add(employee);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employees=" + employees +
                '}';
    }
}
