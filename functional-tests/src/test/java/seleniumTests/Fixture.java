package seleniumTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;

public class Fixture {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeAll() {
        System.out.println("<--- Start test suite --->");
    }

    @Before
    public void setUpBeforeEach() {
        driver = WebDriverFactory.getInstance();
        //System.out.println("<--- Start test xxx --->");
    }

    @After
    public void tearDownAfterEach() {
        driver.quit();
        //System.out.println("<--- Test suite finished --->");
    }

    @AfterClass
    public static void tearDownAfterAll() {
        System.out.println("<--- Test suite finished --->");
    }
}
