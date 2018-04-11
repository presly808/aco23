package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathUtilsTest {

    @Test
    public void getUsersDbPath() {
        assertEquals("src/main/java/user_db.txt", PathUtils.getUsersDbPath());
    }

    @Test
    public void getOrdersDbPath() {
        assertEquals("src/main/java/order_db.txt", PathUtils.getOrdersDbPath());

    }
}