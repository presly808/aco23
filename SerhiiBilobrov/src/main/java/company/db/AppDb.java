package company.db;

import company.model.Employee;
import company.model.Manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 20.01.18.
 */
public final class AppDb {

    private final Map<Integer, Employee> employeeMap;
    private int id = 1;

    public AppDb() {
        employeeMap = new HashMap<>();
    }

    public Employee add(Employee employee){
        employee.setId(id);
        employeeMap.put(id++, employee);
        return employee;
    }

    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee remove(int id){
        return employeeMap.remove(id);
    }

    public Employee getById(int id){
        return employeeMap.get(id);
    }

}
