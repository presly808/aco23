package company.model;

import week2.Worker;

import java.util.Arrays;
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

    @Override
    public int calculateSalary() {
        return salary + employeeList.stream().mapToInt(Employee::getSalary).sum() / 20;
    }

    @Override
    public String toString() {
        return "Manager{" +
                ", name='" + name + '\'' +
                ", employeeList=" + Arrays.toString(employeeList.toArray()) +
                '}';
    }
}
