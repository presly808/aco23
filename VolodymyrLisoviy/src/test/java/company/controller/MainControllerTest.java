package company.controller;

import company.db.AppDb;
import company.model.Manager;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import company.model.Employee;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class MainControllerTest {
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
    public void getById() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getById(withId.getId()), CoreMatchers.equalTo(withId));

    }

    @Test
    public void findWithFilter() {

        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        mainController.addEmployee(new Employee("anton", 3000));
        mainController.addEmployee(new Employee("Andrey", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.findWithFilter("an").size(), CoreMatchers.equalTo(2));

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

}