package company.db;

import company.model.Employee;
import company.model.Manager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppDbTest {

    private AppDb appDb;
    private List<Employee> employees;

    @Before
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee("1", 3000));
        employees.add(new Employee("2", 4000));
        employees.add(new Employee("3", 5000));
        employees.add(new Employee("4", 6000));
        employees.add(new Manager("5", 6000));

        appDb = new AppDb(employees);
    }

    @Test
    public void add() {
        Employee employee = new Manager("6", 7000);
        appDb.add(employee);
        assertTrue(appDb.getAll().contains(employee));
    }

    @Test
    public void getAll() {
        assertEquals(employees, appDb.getAll());
    }

    @Test
    public void remove() {
        Employee employee1 = new Manager("6", 7000);
        Employee employee2 = new Manager("6", 7000);
        Employee employee3 = new Manager("6", 7000);

        appDb.add(employee1);
        appDb.add(employee2);
        appDb.add(employee3);

        assertEquals(employee1, appDb.remove(employee1.getId()));
    }

    @Test
    public void getById() {
        Employee employee1 = new Manager("6", 7000);
        Employee employee2 = new Manager("6", 8000);
        Employee employee3 = new Manager();

        employee3.setName("6");
        employee3.setSalary(9000);

        appDb.add(employee1);
        appDb.add(employee2);
        appDb.add(employee3);

        assertEquals(employee1, appDb.getById(employee1.getId()));
    }
}