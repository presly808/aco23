package company.model;

import java.util.LinkedList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private List<Employee> employeeList;

    public Manager() {
        super();
        this.employeeList = new LinkedList<>();
    }

    public Manager(String name, int salary) {
        super(name,salary);
        this.employeeList = new LinkedList<>();
    }

    public boolean addSubworker(Employee employee){
        return employee != null && employeeList.add(employee);
    }

    public List<Employee> getSubworkers(){
        return employeeList;
    }
}
