package java8.groupbyagg;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    User testUser;

    @Before
    public void setUp() {
        testUser = new User(0, "Ivan",  10, null);
    }

    @Test
    public void equals() {
        assertEquals(new User(0, "blabla", 0, null), testUser);
    }

    @Test
    public void hashCodeTest() {
        assertEquals(330, testUser.hashCode());
    }
}
