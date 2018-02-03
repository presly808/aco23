package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.model.Manager;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerProfilingTest {


    @Test
    public void addEmployee() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));
    }

    @Test
    public void getAllEmployees() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getAllEmployees().size(), CoreMatchers.equalTo(2));
    }

    @Test
    public void calculateSalary() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.calculateSalary(withId), CoreMatchers.equalTo(3000));
    }

    @Test
    public void getById() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getById(withId.getId()), CoreMatchers.equalTo(withId));
    }

    @Test
    public void findWithFilter() {

        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        mainController.addEmployee(new Employee("anton", 3000));
        mainController.addEmployee(new Employee("Andrey", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.findWithFilter("an").size(), CoreMatchers.equalTo(3));
    }

    @Test
    public void calculateSalaries() {

        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));

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
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));

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

        List<Employee> result = mainController.filterWithPredicate((employee -> {
            boolean res = true;

            return employee.getSalary() >= 3000 && res;

        }), Comparator.comparing(Employee::getName));


        assertThat(result, CoreMatchers.hasItem(emp2));
        assertThat(result, CoreMatchers.hasItem(emp3));
        assertThat(result.get(0).getName(), CoreMatchers.equalTo("Andrey"));

    }

    @Test
    public void fireWorker() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));

        Employee emp1 = new Employee("anton", 1000);

        emp1.setBirthday(new GregorianCalendar(1990, 4, 22));
        emp1.setStartWorkDate(new Date());
        mainController.addEmployee(emp1);

        assertThat(mainController.fireWorker(emp1.getId()), CoreMatchers.equalTo(emp1));
    }

    @Test
    public void areWorkersEqual() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Ivan", 3000));
        assertFalse(mainController.areWorkersEqual(em1.getId(), em2.getId()));
    }


    @Test
    public void areWorkersNotEqual() {
        MainControllerProfiling mainController = new MainControllerProfiling(new MainControllerImpl(new AppDb()));
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Serhey", 3000));

        assertFalse(mainController.areWorkersEqual(em1.getId(), em2.getId()));
    }

}