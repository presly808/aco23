package company.controller;

import company.db.AppDb;
import company.model.Manager;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import company.model.Employee;

import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerTest {

    @Test
    public void areWorkersEqual() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Ivan", 3000));

        assertTrue(mainController.areWorkersEqual(em1.getId(),em2.getId()));
    }

    @Test
    public void areWorkersNotEqual() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Serhey", 3000));

        assertFalse(mainController.areWorkersEqual(em1.getId(),em2.getId()));
    }

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
        assertThat(mainController.findWithFilter("an").size(), CoreMatchers.equalTo(3));
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
    public void filterWithPredicate() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());

        Employee emp1 = new Employee("anton", 1000);
        emp1.setBirthday(new GregorianCalendar(1990, 4, 22));
        emp1.setStartWorkDate(new Date());

        Employee emp2 = new Employee("Andrey", 3000);
        emp2.setBirthday(new GregorianCalendar(1985, 4, 22));
        emp2.setStartWorkDate(new Date(new GregorianCalendar(2017, 4, 22).toInstant().toEpochMilli()));

        Employee emp3 = new Employee("Ivan", 4000);
        emp3.setBirthday(new GregorianCalendar(1990, 4, 22));
        emp3.setStartWorkDate(new Date(new GregorianCalendar(2017, 4, 22).toInstant().toEpochMilli()));

        mainController.addEmployee(emp1);
        mainController.addEmployee(emp2);
        mainController.addEmployee(emp3);

        List<Employee> result = mainController.filterWithPredicate((employee -> employee.getSalary() >= 3000),
                Comparator.comparing(Employee::getName));

        assertThat(result, CoreMatchers.hasItem(emp2));
        assertThat(result, CoreMatchers.hasItem(emp3));
        assertThat(result.get(0).getName(), CoreMatchers.equalTo("Andrey"));
    }

    @Test
    public void fireWorker() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());

        Employee emp1 = new Employee("anton", 1000);
        emp1.setBirthday(new GregorianCalendar(1990, 4, 22));
        emp1.setStartWorkDate(new Date());

        mainController.addEmployee(emp1);

        assertThat(mainController.fireWorker(emp1.getId()), CoreMatchers.equalTo(emp1));
    }

    @Test
    public void updateWorker() {
        MainControllerImpl mainController = new MainControllerImpl(new AppDb());
        Employee em1 = new Employee("Ivan", 3000);
        Employee em2 = new Employee(
                "Ivan",
                3000,
                new GregorianCalendar(2013,10,28),
                new Date());

        mainController.addEmployee(em1);
        mainController.updateWorker(em2);

        assertTrue(em1.equals(em2));
        assertThat(mainController.getAllEmployees().get(0).getStartWorkDate().toString(),
                CoreMatchers.equalTo(new Date().toString()));
    }
}