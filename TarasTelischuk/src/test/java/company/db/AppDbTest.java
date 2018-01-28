package company.db;

import company.model.Employee;
import company.model.Manager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppDbTest {

    private AppDb appDb;
    private List<Employee> employees;

    @Before
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee("Sasha", 4300));
        employees.add(new Employee("Jack", 4800));
        employees.add(new Manager("Patrick", 6000));
        employees.add(new Manager("Tom", 5750));

        appDb = new AppDb(employees);
    }

    @Test
    public void add() throws Exception {
        Employee employee = new Manager("Igor", 5600);
        appDb.add(employee);
        assertTrue(appDb.getAll().contains(employee));
    }

    @Test
    public void getAll() throws Exception {
        assertEquals(employees, appDb.getAll());

    }

    @Test
    public void remove() throws Exception {
        Employee employee = new Employee("Oleg", 2800);
        appDb.add(employee);
        assertEquals(employee, appDb.remove(employee.getId()));
    }

    @Test
    public void getById() throws Exception {
        Employee employee = new Employee("Sasha", 4900);
        appDb.add(employee);
        assertEquals(employee, appDb.getById(employee.getId()));
    }
}