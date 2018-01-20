package company.controller;

import company.db.AppDb;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import company.model.Employee;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void addEmployee() throws Exception {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));


    }

    @Test
    public void getAllEmployees() throws Exception {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getAllEmployees().size(), CoreMatchers.equalTo(2));

    }

    @Test
    public void calculateSalary() throws Exception {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.calculateSalary(withId), CoreMatchers.equalTo(3000));
    }

    @Test
    public void getById() throws Exception {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getById(withId.getId()), CoreMatchers.equalTo(withId));

    }

    @Test
    public void findWithFilter() throws Exception {
    }

}