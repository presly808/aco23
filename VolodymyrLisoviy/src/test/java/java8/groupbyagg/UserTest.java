package java8.groupbyagg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.id = 0;
        user.money = 1000;
        user.department = null;
        user.name = "sda";
    }

    @Test
    public void equals() {
        Assert.assertEquals(new User(0, "asd", 0, null), user);
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(0, user.hashCode());
    }
}