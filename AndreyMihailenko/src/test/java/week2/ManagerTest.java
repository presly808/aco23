package week2;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serhii on 19.01.18.
 */
public class ManagerTest {

    private Manager manager;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Andrey", 3000);
    }

    @Test
    public void calculateSalary() {
        Manager manager = new Manager("Oleg", 3000);
        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));
        manager.addSubworker(new Employee("Olena", 2000));

        Assert.assertThat(manager.calculateSalary(), CoreMatchers.equalTo(3300));

    }

    @Test
    public void calculateSalary1() {
        Manager manager = new Manager("Oleg", 3000);
        Manager manager1 = new Manager("Andrey", 4000);

        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));

        manager.addSubworker(manager1);

        int actual = 3000 + (2000 / 20 + 2000 / 20) + 4000 / 20;

        Assert.assertThat(manager.calculateSalary(), CoreMatchers.equalTo(actual));

    }

    @Test
    public void addSubworker() {
        Manager manager = new Manager("Oleg", 3000);
        Assert.assertThat(manager.addSubworker(new Employee("Ivan", 2000)),
                CoreMatchers.equalTo(true));
    }

    @Test
    public void getSubworkers() {
        Manager manager = new Manager("Oleg", 3000);
        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));
        manager.addSubworker(new Employee("Petro", 2000));

        Assert.assertThat(manager.getSubworkers().size(), CoreMatchers.equalTo(3));
    }

    @Test
    public void getName() {
        assertEquals("Andrey", manager.getName());
    }

}