package seleniumTests;

import org.junit.Test;

public class LoginTests extends Fixture {

    @Test
    public void test1() {
        System.out.println("hello");
        System.out.println("YRA");
        driver.navigate().to("https://www.google.com.ua/");
    }
}
