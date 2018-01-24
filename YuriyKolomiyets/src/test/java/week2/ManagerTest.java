package week2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ManagerTest {

    @Test
    public void getName() {
        Manager manager = new Manager("Oleg", 300);
        assertEquals("Oleg", manager.getName());
    }

    @Test
    public void setName() {
        Manager manager = new Manager();
        manager.setName("Oleg");
        assertEquals("Oleg", manager.getName());
    }

    @Test
    public void getSalary() {
        Manager manager = new Manager("Oleg", 300);
        assertEquals(300, manager.getSalary());
    }

    @Test
    public void setSalary() {
        Manager manager = new Manager();
        manager.setSalary(300);
        assertEquals(300, manager.getSalary());
    }

    @Test
    public void calculateSalary() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        Employee employee2 = new Employee("Ivan", 2000);
        manager.addSubworker(employee1);
        manager.addSubworker(employee2);
        assertEquals(0, manager.calculateSalary());
    }

    @Test
    public void addSubworker() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        manager.addSubworker(employee1);
        assertEquals(1, manager.getWorkersList().size());
    }

    @Test
    public void getSubworkers() {
        Manager manager = new Manager("Oleg", 300);
        Employee employee1 = new Employee("Ivan", 1000);
        manager.addSubworker(employee1);
        assertEquals(employee1, manager.getSubworkers().get(0));
    }
}