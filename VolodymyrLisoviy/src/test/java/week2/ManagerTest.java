package week2;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void calculateSalary2() {
        Manager manager = new Manager("Main manager", 4000);

        Manager manager1 = new Manager("Manager 1" , 1000);
        manager1.addSubworker(new Employee("Ivan", 2000));
        manager1.addSubworker(new Employee("Valera", 2000));

        manager.addSubworker(manager1);
        manager.addSubworker(new Employee("Petro", 2000));

        int actual = 4000 + 2000 / 20 + (1000 + 2000 / 20 + 2000 / 20) / 20;

        assertEquals(actual, manager.calculateSalary());
    }

}