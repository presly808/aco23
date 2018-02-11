package java8.groupbyagg;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp()  {
        department = new Department(1, "IT", "KIEV");
    }

    @Test
    public void getId() {
        assertEquals(1, department.getId());
    }

    @Test
    public void setId() {
        department.setId(2);
        assertEquals(2, department.getId());
    }

    @Test
    public void getName() {
        assertEquals("IT", department.getName());
    }

    @Test
    public void setName() {
        department.setName("SUPPORT");
        assertEquals("SUPPORT", department.getName());
    }

    @Test
    public void getCity() {
        assertEquals("KIEV", department.getCity());
    }

    @Test
    public void setCity() {
        department.setCity("BUCHA");
        assertEquals("BUCHA", department.getCity());
    }


}