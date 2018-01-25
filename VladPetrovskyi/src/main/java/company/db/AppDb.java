package company.db;

import company.model.Employee;
import company.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 20.01.18.
 */
public class AppDb {

    List<Employee> employees = new ArrayList<>(); // 100 (98 emp, 2 manager)

    public Employee add(Employee employee) {
        employee.setId(MyUtils.genId(100));
        employees.add(employee);

        return employee;
    }

    public List<Employee> getAll() {
        return employees;
    }

    public Employee remove(int id) { // 50
        int index = 0;

        if(employees.size() == 0) {
            return null;
        }

        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) { // 50 = 50
                index = i; // todo add break;
            }
        }

        return employees.remove(index);
    }

    public Employee getById(int id) {

       int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()){
                index = i;
            }
        }
        return employees.get(index);
    }
}