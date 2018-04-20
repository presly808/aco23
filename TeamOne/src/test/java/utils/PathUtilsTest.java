package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathUtilsTest {

    @Test
    public void getUsersDbPath() {
        assertEquals("src/main/java/dbResources/user_db.txt", PathUtils.getUsersDbPath());
    }

    @Test
    public void getOrdersDbPath() {
        assertEquals("src/main/java/dbResources/order_db.txt", PathUtils.getOrdersDbPath());

    }

    @Test
    public void getLog4jPath() {
        assertEquals("log4j.properties", PathUtils.getLog4jPath());
    }

    @Test
    public void getServerPort() {
        assertEquals("5000", PathUtils.getServerPort());
    }

    @Test
    public void getServerHost() {
        assertEquals("http://localhost:5000", PathUtils.getServerHost());
    }

    @Test
    public void getStaticFolder() {
        assertEquals("view", PathUtils.getStaticFolder());
    }
}