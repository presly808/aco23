package company.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("Andrey", 3000);
        employee.setBirthday(new GregorianCalendar(1990, 4, 22));
        employee.setStartWorkDate(new Date(new GregorianCalendar(2009, 4, 22).
                toInstant().toEpochMilli()));
        employee.setEndWorkDate(new Date(new GregorianCalendar(2017, 2, 3).
                toInstant().toEpochMilli()));
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
    public void getBirthday() {
        assertEquals(new GregorianCalendar(1990, 4, 22), employee.getBirthday());
    }

    @Test
    public void setBirthday() {
        employee.setBirthday(new GregorianCalendar(1998, 7, 9));
        assertEquals(new GregorianCalendar(1998, 7, 9), employee.getBirthday());
    }

    @Test
    public void getStartWorkDate() {
        assertEquals(new Date(new GregorianCalendar(2009, 4, 22).
                toInstant().toEpochMilli()), employee.getStartWorkDate());
    }

    @Test
    public void setStartWorkDate() {
        employee.setStartWorkDate(new Date(new GregorianCalendar(2010, 5, 3).
                toInstant().toEpochMilli()));
        assertEquals(new Date(new GregorianCalendar(2010, 5, 3).
                toInstant().toEpochMilli()), employee.getStartWorkDate());
    }

    @Test
    public void getEndWorkDate() {
        assertEquals(new Date(new GregorianCalendar(2017, 2, 3).
                toInstant().toEpochMilli()), employee.getEndWorkDate());
    }

    @Test
    public void setEndWorkDate() {
        employee.setEndWorkDate(new Date(new GregorianCalendar(2017, 1, 22).
                toInstant().toEpochMilli()));
        assertEquals(new Date(new GregorianCalendar(2017, 1, 22).
                toInstant().toEpochMilli()), employee.getEndWorkDate());
    }
}