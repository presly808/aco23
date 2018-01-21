package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager extends Employee {


    private List<Employee> employees;

    public Manager() {
        super();
        employees = new ArrayList<>();
    }

    public Manager(String name, int salary) {
        super(name,salary);
        employees = new ArrayList<>();

    }


    public boolean addSubworker(Employee employee) {
        return employee != null && employees.add(employee);
    }

    public List<Employee> getSubworkers(){
        return employees;
    }

    @Override
    public int calculateSalary(Employee employee) {
        int res = getSalary();
        for (Employee employee1 : employees){
            res += employee.getSalary() / 20;
        }
        return res;
    }
}
