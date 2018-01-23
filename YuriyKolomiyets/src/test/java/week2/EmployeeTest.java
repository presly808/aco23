package week2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void getName() {
        Employee employee = new Employee("Oleg", 300);
        Assert.assertEquals("Oleg", employee.getName());
    }

    @Test
    public void setName() {
        Employee employee = new Employee();
        employee.setName("Oleg");
        Assert.assertEquals("Oleg", employee.getName());
    }

    @Test
    public void getSalary() {
        Employee employee = new Employee("Oleg", 300);
        Assert.assertEquals(300, employee.getSalary());
    }

    @Test
    public void setSalary() {
        Employee employee = new Employee();
        employee.setSalary(100);
        Assert.assertEquals(100, employee.getSalary());
    }

    @Test
    public void calculateSalary() {
        Employee employee = new Employee();
        employee.setSalary(100);
        Assert.assertEquals(100, employee.calculateSalary());
    }
}