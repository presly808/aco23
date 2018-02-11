package seleniumTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;

public class Fixture {

    public WebDriver driver;

    @Before
    public void setUpBeforeEach() {
        driver = WebDriverFactory.getInstance();
    }

    @After
    public void tearDownAfterEach() {
        driver.quit();
    }
}
