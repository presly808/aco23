package seleniumTests;

import selenium.WebDriverFactory;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import selenium.ClassNameUtil;

@Tag("login")
public class LoginTests extends Fixture {

    WebDriver driver;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getInstance();
        //log.info("<--- Start test xxx --->");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        //log.info("<--- Test suite finished --->");
    }

    @Test
    @DisplayName("╯°□°）╯")
    public void test1() {
        driver = WebDriverFactory.getInstance();
        System.out.println("YRA");
        driver.navigate().to("https://www.google.com.ua/");
    }
}
