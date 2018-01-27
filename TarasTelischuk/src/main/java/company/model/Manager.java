package company.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {

    private  List<Employee> employees;

    public Manager(){
        super();
        this.employees = new ArrayList<>();
    }

    public Manager(String name, int salary) {
        super(name,salary);
        this.employees = new ArrayList<>();

    }

    public boolean addSubworker(Employee employee){
       if(employee != null) {
           employees.add(employee);
           return true;
       }
       return false;
    }

    public List<Employee> getSubworkers(){
        return employees;
    }

    @Override
    public int calculateSalary() {
        return salary + employees.stream().mapToInt(Employee::getSalary).sum() / 20;
    }

    @Override
    public String toString() {
        return "Manager{" +
                ", name='" + name + '\'' +
                "employees=" + Arrays.toString(employees.toArray()) +
                '}';
    }
}
