package company.controller;

import company.db.AppDb;
import company.model.Employee;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainControllerImplMockTest {

    private MainController mainController;

    @Before
    public void setUp() {
        AppDb appDb = mock(AppDb.class);
        when(appDb.add(any(Employee.class)))
                .thenReturn(new Employee("20", 2000));
        when(appDb.getAll())
                .thenReturn(Arrays.asList(new Employee("1", 2000), new Employee("2", 300)));

        mainController = new MainControllerImpl(appDb);
    }

    @Test
    public void addEmployee() {
        Employee withId = mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(withId.getId(), CoreMatchers.not(0));
    }

    @Test
    public void getAllEmployees() {
        mainController.addEmployee(new Employee("Ivan", 3000));
        mainController.addEmployee(new Employee("Ivan", 3000));
        assertThat(mainController.getAllEmployees().size(), CoreMatchers.equalTo(2));
    }
}