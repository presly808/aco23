package company.model;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {

    @Test
    public void getName() {
        Manager manager = new Manager("Oleg", 300);
        Assert.assertEquals("Oleg", manager.getName());
    }

    @Test
    public void setName() {
        Manager manager = new Manager();
        manager.setName("Oleg");
        Assert.assertEquals("Oleg", manager.getName());
    }

    @Test
    public void getSalary() {
        Manager manager = new Manager("Oleg", 300);
        Assert.assertEquals(300, manager.getSalary());
    }

    @Test
    public void setSalary() {
        Manager manager = new Manager();
        manager.setSalary(300);
        Assert.assertEquals(300, manager.getSalary());
    }

    @Test
    public void calculateSalary() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        Employee employee2 = new Employee("Ivan", 2000);
        manager.addSubworker(employee1);
        manager.addSubworker(employee2);
        Assert.assertEquals(450, manager.calculateSalary());
    }

    @Test
    public void addSubworker() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        manager.addSubworker(employee1);
        Assert.assertEquals(1, manager.getWorkersList().size());
    }

    @Test
    public void getSubworkers() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        manager.addSubworker(employee1);
        Assert.assertEquals(employee1, manager.getSubworkers().get(0));
    }
}