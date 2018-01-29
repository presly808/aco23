package company.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManagerTest {

    private Manager manager;

    @Before
    public void setUp() {
        manager = new Manager("Andrey", 3000);
    }

    @Test
    public void addSubworker() {
        Manager manager = new Manager("Oleg", 3000);
        Assert.assertThat(manager.addSubworker(new Employee("Ivan", 2000)),
                CoreMatchers.equalTo(true));
    }

    @Test
    public void getSubworkers() {
        manager.addSubworker(new Employee("Ivan", 2000));
        manager.addSubworker(new Employee("Valera", 2000));
        manager.addSubworker(new Employee("Petro", 2000));

        Assert.assertThat(manager.getSubworkers().size(), CoreMatchers.equalTo(3));
    }
}