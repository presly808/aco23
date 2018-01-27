package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.model.Manager;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerProxyTest {

    @Test
    public void addEmployee() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));
    }

    @Test
    public void getAllEmployees() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getAllEmployees().size(), CoreMatchers.equalTo(2));
    }

    @Test
    public void calculateSalary() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.calculateSalary(withId), CoreMatchers.equalTo(3000));
    }

    @Test
    public void calculateSalaries() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());

        Manager man = new Manager("anton", 5000);
        man.addSubworker(new Employee("1", 1000));
        man.addSubworker(new Employee("2", 1000));

        mainController.addEmployee(man);
        mainController.addEmployee(new Employee("anton", 3000));
        mainController.addEmployee(new Employee("Andrey", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.calculateSalaries(), CoreMatchers.equalTo(9000 + 5100));
    }

    @Test
    public void getById() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getById(withId.getId()), CoreMatchers.equalTo(withId));
    }

    @Test
    public void addListener() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        mainController.addListener(obj -> {
        });
        assertThat(mainController.getListeners().size(), CoreMatchers.not(0));

    }

    @Test
    public void callListener() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        mainController.addListener(obj -> {
            Assert.assertThat(obj.getPlace(), CoreMatchers.containsString("fireWorker"));

        });
        Employee saved = mainController.addEmployee(new Employee(String.valueOf("test"),1000));
        mainController.fireWorker(saved.getId());

    }

    @Test
    public void filterWithPredicate() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());

        Employee emp1 = new Employee("anton", 1000);
        Employee emp2 = new Employee("Andrey", 3000);
        Employee emp3 = new Employee("Ivan", 4000);
        mainController.addEmployee(emp1);
        mainController.addEmployee(emp2);
        mainController.addEmployee(emp3);

        List<Employee> result = mainController.filterWithPredicate((employee -> {
            boolean res = true;
            if (employee.getSalary() < 3000) {
                return false;
            }
            return res;

        }), Comparator.comparing(Employee::getName));

        assertThat(result.get(0).getName(), CoreMatchers.equalTo("Andrey"));
    }

    @Test
    public void areWorkersEqual() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Ivan", 3000));
        assertFalse(mainController.areWorkersEqual(em1.getId(), em2.getId()));
    }
}