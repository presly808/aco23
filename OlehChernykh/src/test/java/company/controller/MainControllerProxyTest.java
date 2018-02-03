package company.controller;

import company.db.AppDb;
import company.model.Employee;
import company.model.Manager;
import company.utils.factory.MainFactory;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerProxyTest {

    @Test
    public void addEmployee() {
        MainControllerProxy mainControllerProxy = new MainControllerProxy(
                new MainControllerImpl(new AppDb()));
        Employee withId = mainControllerProxy.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));
    }

    @Test
    public void getAllEmployees() {
        MainController mainController = MainFactory.create(true);
        mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getAllEmployees().size(), CoreMatchers.equalTo(2));
    }

    @Test
    public void calculateSalary() {
        MainController mainController = MainFactory.create(true);
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.calculateSalary(withId), CoreMatchers.equalTo(3000));
    }

    @Test
    public void calculateSalaries() {
        MainController mainController = MainFactory.create(true);

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
        MainController mainController = MainFactory.create(true);
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
    public void filterWithPredicate() {
        MainController mainController = MainFactory.create(true);

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
        MainController mainController = MainFactory.create(true);
        Employee em1 = mainController.addEmployee(new Employee("Ivan", 3000));
        Employee em2 = mainController.addEmployee(new Employee("Ivan", 3000));
        assertFalse(mainController.areWorkersEqual(em1.getId(), em2.getId()));
    }

    @Test
    public void findWithFilter() {
        MainController mainController = MainFactory.create(true);
        mainController.addEmployee(new Employee("anton", 3000));
        mainController.addEmployee(new Employee("Andrey", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.findWithFilter("an").size(), CoreMatchers.equalTo(3));
    }
}