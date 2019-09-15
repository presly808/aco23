package java8.groupbyagg;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() {
        department = new Department(0, "Ivan", "Kiev");
    }

    @Test
    public void equals() {
        assertEquals(new Department(0, "Vasia", ""), department);
    }

    @Test
    public void hashCodeTest() {
        assertEquals(0, department.hashCode());
    }
}
