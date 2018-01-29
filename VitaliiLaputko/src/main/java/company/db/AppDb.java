package company.db;

import company.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public class AppDb {

    private List<Employee> employeesDb = new ArrayList<>();

    public Employee add(Employee employee){
        employeesDb.add(employee);
        System.out.println("Employee " + employee.getName() + " was added successfully");

        return employee;
    }

    public List<Employee> getAll(){
        return employeesDb;
    }

    public Employee remove(int id){
        Employee employee = getById(id);

        if (employee != null) {
            System.out.println("Employee " + employee.getName()
                    + " was deleted successfully");
            employeesDb.remove(employee);

            return employee;
        }
        return null;
    }

    public Employee getById(int id){
        for (Employee employee : employeesDb) {
            if (employee.getId() == id){
                System.out.println("Got employee " + employee.getName());

                return employee;
            }
        }
        return null;
    }

    public Employee update(Employee employee) {
        for (int i = 0; i < employeesDb.size(); i++)
            if (employeesDb.get(i).equals(employee)) {
            employeesDb.set(i, employee);
            return employee;
        }
        return null;
    }
}
