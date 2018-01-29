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

    public boolean addSubworker(Employee employee){
        return subworkers.add(employee);
    }

    public List<Employee> getSubworkers(){
        return subworkers;
    }

    @Override
    public int calculateSalary() {
        int subSalaries = subworkers.stream().mapToInt(Employee::calculateSalary).sum() / 20;
        return this.getSalary() + subSalaries;
    }
}
