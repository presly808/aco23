package company.db;

import company.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppDbTest {

    private AppDb appDb;

    @Before
    public void setUp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Andrey", 3456));
        employees.add(new Employee("Vova", 2567));
        employees.add(new Employee("Sanya", 2333));
        employees.add(new Employee("Kolya", 3574));
        appDb = new AppDb(employees);
    }

    @Test
    public void add() {
        Employee employee = appDb.add(new Employee("Vasya", 4999));
        assertTrue(appDb.getAll().contains(employee));
    }


    @Test
    public void remove() {
        Employee employee = new Employee("Serhiy", 6000);

        appDb.add(employee);

        assertEquals(employee, appDb.remove(employee.getId()));
    }

    @Test
    public void getById() {
        Employee employee = new Employee("Misha", 1000);

        appDb.add(employee);

        assertEquals(employee, appDb.getById(employee.getId()));
    }
}