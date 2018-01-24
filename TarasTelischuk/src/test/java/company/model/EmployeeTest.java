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
    public void calculateSalary(){
        employee.setSalary(100);
        assertEquals(100, employee.calculateSalary());
    }


    @Test
    public void getName()  {
        assertEquals("Andrey", employee.getName());
    }

    @Test
    public void setName() {
        employee.setName("Edik");
        assertEquals("Edik", employee.getName());
    }

    @Test
    public void getSalary()  {
        assertEquals(3000, employee.getSalary());
    }

    @Test
    public void getBirthday(){
        assertEquals(new GregorianCalendar(1990, 4, 22), employee.getBirthday());
    }

    @Test
    public void setBirthday(){
        employee.setBirthday(new GregorianCalendar(2006, 3, 27));
        assertEquals(new GregorianCalendar(2006, 3, 27), employee.getBirthday());
    }


}