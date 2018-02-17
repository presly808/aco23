package java8.groupbyagg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() {
        department = new Department();
        department.id = 0;
        department.name = "asda";
        department.city = "ad";
    }

    @Test
    public void equals() {
        Assert.assertEquals(new Department(0, "a", ""), department);
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(0, department.hashCode());

    }
}