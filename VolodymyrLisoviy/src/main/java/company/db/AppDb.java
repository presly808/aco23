package company.db;

import company.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by serhii on 20.01.18.
 */
public class AppDb {

    private List<Employee> employeeList;

    public AppDb() {
        this.employeeList = new ArrayList<>();
    }

    public AppDb(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(employeeList);
    }

    public Employee add(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee remove(int id) {
        Employee employee = null;
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                employee = e;
                break;
            }
        }
        employeeList.remove(employee);

        return employee;
    }

    public Employee getById(int id) {
        for (Employee e : employeeList)
            if (e.getId() == id)
                return e;

        return null;
    }

    public Employee update(Employee employee) {
        ListIterator<Employee> itr = employeeList.listIterator();
        Employee employee1 = null;
        while (itr.hasNext()) {
            if ((employee1 = itr.next()).equals(employee)) {
                itr.set(employee);
                break;
            }
        }
        return employee1;
    }
}
