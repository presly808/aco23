package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private List<Employee> employees = new ArrayList<>(); // initialize

    public Manager(String name, int salary) {
        super(name, salary);
    }

    public boolean addSubworker(Employee employee) {
        return employees.add(employee);
    }

    public List<Employee> getSubworkers() {
        return employees;
    }

/*        Employee manager = new Manager("Vlad", 3432432);
//        manager.addSubworker();
        Manager manager1 = (Manager) manager
        manager1.addSubworker();*/
}
