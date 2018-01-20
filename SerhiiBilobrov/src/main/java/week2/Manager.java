package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    public static final int _5_PERCENT = 20;
    private List<Employee> employees;

    public Manager(String name, int salary) {
        super(name,salary);

        this.employees = new ArrayList<>();

    }


    // manager has fixed salary + 5% from each employee that subordinate to manager
    public int calculateSalary(){
        return getSalary() + employees.stream().mapToInt(employee -> employee.getSalary()).sum() / _5_PERCENT;
    }

    public boolean addSubworker(Employee employee){
        return employees.add(employee);
    }

    public List<Employee> getSubworkers(){
        return employees;
    }


}
