package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private List<Employee> subworkers;

    public Manager(String name, int salary) {
        super(name,salary);
        subworkers = new ArrayList<>();
    }

    public int getSalary(Employee employee){
        int salary = getSalary();

        for (Employee em: subworkers) {
            salary += em.getSalary() / 100 * 5;
        }

        System.out.println("Employee " + employee.getName() + " salary => " + salary);

        return salary;
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
