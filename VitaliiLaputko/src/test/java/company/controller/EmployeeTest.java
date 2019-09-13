package company.controller;

import company.model.Employee;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Test
    public void checkEmployeeEquals() {
        Employee employee1 = new Employee("Oleg", 3000);
        Employee employee2 = new Employee(
                "Oleg",
                3000,
                new GregorianCalendar(2013,10,28),
                new Date());

        assertThat(employee1.equals(employee2), CoreMatchers.is(true));
    }

    @Test
    public void checkSetNameAndSalary() {
        Employee employee = new Employee("Ivan", 2000);
        employee.setName("Oleg");
        employee.setSalary(3000);

        assertThat(employee, CoreMatchers.is(new Employee("Oleg", 3000)));
    }

    @Test
    public void checkBirthdaySet() {
        Employee employee = new Employee(
                "Oleg",
                3000,
                new GregorianCalendar(2018,1,29),
                new Date());

        employee.setBirthday(new GregorianCalendar(1991,4,28));

        assertThat(employee.getBirthday(),
                CoreMatchers.equalTo(new GregorianCalendar(1991,4,28)));
    }

    @Test
    public void checkBirthdayGet() {
        Employee employee = new Employee(
                "Oleg",
                3000,
                new GregorianCalendar(2018,1,29),
                new Date());

        assertThat(employee.getBirthday(),
                CoreMatchers.equalTo(new GregorianCalendar(2018, 1,29)));
    }
}
