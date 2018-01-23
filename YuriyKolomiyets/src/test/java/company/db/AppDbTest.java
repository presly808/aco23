package company.db;

import company.controller.MainControllerImpl;
import company.model.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppDbTest {

    @Test
    public void getWorkersList() {
       AppDb appDb = new AppDb();
       appDb.add(new Employee("anton", 1000));
        assertEquals("anton", appDb.getWorkersList().get(0).getName());

    }

    @Test
    public void add() {
        AppDb appDb = new AppDb();
        appDb.add(new Employee("anton", 1000));
        assertEquals("anton", appDb.getWorkersList().get(0).getName());
    }

    @Test
    public void getAll() {
        AppDb appDb = new AppDb();
        appDb.add(new Employee("anton", 1000));
        assertEquals("anton", appDb.getAll().get(0).getName());
    }
}