package java8.groupbyagg;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private Department department1;
    private Department department2;
    private User user;

    @Before
    public void setUp() {
        department1 = new Department(1, "IT", "KIEV");
        department2 = new Department(2, "SUPPORT", "BUCHA");
        user = new User(11, "Andrey", 2000.0, department1);
    }

    @Test
    public void getId() {
        assertEquals(11, user.getId());
    }

    @Test
    public void setId() {
        user.setId(22);
        assertEquals(22, user.getId());
    }

    @Test
    public void getName() {
        assertEquals("Andrey", user.getName());
    }

    @Test
    public void setName() {
        user.setName("Serhiy");
        assertEquals("Serhiy", user.getName());
    }


    @Test
    public void getDepartment() {
        assertEquals(department1, user.getDepartment());
    }

    @Test
    public void setDepartment() {
        user.setDepartment(department2);
        assertEquals(department2, user.getDepartment());
    }
}