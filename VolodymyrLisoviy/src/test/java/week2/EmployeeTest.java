package week2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("1", 1000);
    }

    @Test
    public void getName() {
        assertEquals("1", employee.getName());
    }

    @Test
    public void setName() {
        employee.setName("2");
        assertEquals("2", employee.getName());
    }

    @Test
    public void getSalary() {
        assertEquals(1000, employee.getSalary());
    }

    @Test
    public void setSalary() {
        employee.setSalary(20);
        assertEquals(20, employee.getSalary());
    }

    @Test
    public void calculateSalary() {
        assertEquals(1000, employee.calculateSalary());
    }
}