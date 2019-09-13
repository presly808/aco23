package ua.artcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee{

    private List<Employee> subworkers;

    public Manager(String name, int salary) {
        super(name, salary);
        subworkers = new ArrayList<>();
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    public int calculateSalary(){
        int s = this.getSalary();

        for (Employee em: subworkers) {
            s += em.getSalary() / 100 * 5;
        }

        return s;
    }

    public boolean addSubworker(Employee employee){
        if (!subworkers.contains(employee)) {
            subworkers.add(employee);
            System.out.println("Employee " + employee.getName() + " was added successfully");

            return true;
        }
        return false;
    }

    public List<Employee> getSubworkers(){
        return subworkers;
    }
}
