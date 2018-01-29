package company.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import ua.artcode.week2.Employee;
import ua.artcode.week2.Manager;

import static org.junit.Assert.assertThat;

/**
 * Created by serhii on 19.01.18.
 */
public class ManagerTest {
    @Test
    public void calculateSalary() {
        Manager manager = new Manager("Oleg", 3000);
        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));
        manager.addSubworker(new Employee("Olena", 2000));

        assertThat(manager.calculateSalary(), CoreMatchers.equalTo(3300));
    }

    @Test
    public void addSubworker() {
        Manager manager = new Manager("Oleg", 3000);
        assertThat(manager.addSubworker(new Employee("Ivan", 2000)),
                CoreMatchers.equalTo(true));
    }

    @Test
    public void getSubworkers() {
        Manager manager = new Manager("Oleg", 3000);
        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));
        manager.addSubworker(new Employee("Petro", 2000));

        assertThat(manager.getSubworkers().size(), CoreMatchers.equalTo(3));
    }
}
