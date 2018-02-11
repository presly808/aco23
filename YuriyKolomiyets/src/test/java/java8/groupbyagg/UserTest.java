package java8.groupbyagg;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getId() {
        User user = new User(1,"Kolia", 3000, new Department());
        assertEquals(1, user.getId());
    }

    @Test
    public void getName() {
        User user = new User(1,"Kolia", 3000, new Department());
        assertEquals("Kolia", user.getName());
    }
}