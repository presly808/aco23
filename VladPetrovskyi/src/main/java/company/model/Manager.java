package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private ArrayList<Employee>employees;

    public Manager(String name, int salary) {
        super(name,salary);
        this.employees = new ArrayList<>();

    }

    public boolean addSubworker(Employee employee){
        return employees.add(employee);
    }

    public List<Employee> getSubworkers(){
        return employees;
    }


}
