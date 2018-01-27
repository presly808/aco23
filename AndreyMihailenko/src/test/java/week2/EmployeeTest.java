package week2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee("Andrey", 3000);
    }

    @Test
    public void getName() {
        assertEquals("Andrey", employee.getName());
    }

    @Test
    public void setName() {
        employee.setName("Vova");
        assertEquals("Vova", employee.getName());
    }

    @Test
    public void getSalary() {
        assertEquals(3000, employee.getSalary());
    }

    @Test
    public void setSalary() {
        employee.setSalary(2000);
        assertEquals(2000, employee.getSalary());
    }
}