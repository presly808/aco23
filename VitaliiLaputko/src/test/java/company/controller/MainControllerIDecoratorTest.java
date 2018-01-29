package company.controller;

import company.model.Employee;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MainControllerIDecoratorTest {

    @Test
    public void addEmployee() {
        MainControllerDecorator mainControllerIDecorator = new MainControllerDecorator();
        Employee withId = mainControllerIDecorator.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));
    }

    @Test
    public void getAllEmployees() {
        MainControllerDecorator mainControllerIDecorator = new MainControllerDecorator();
        mainControllerIDecorator.addEmployee(new Employee("Ivan", 3000));
        mainControllerIDecorator.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainControllerIDecorator.getAllEmployees().size(), CoreMatchers.equalTo(2));
    }
}
