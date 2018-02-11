package seleniumTests;

import selenium.WebDriverFactory;
import org.apache.log4j.Logger;
import org.junit.gen5.api.*;
import org.openqa.selenium.WebDriver;
import selenium.ClassNameUtil;
import selenium.UIMappingSingleton;

public class Fixture {

    public static WebDriver driver;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @BeforeAll
    public static void setUpBeforeAll() {
        UIMappingSingleton.getInstance();
        log.info("<--- Start test suite --->");
    }

    @BeforeEach
    public void setUpBeforeEach() {
        driver = WebDriverFactory.getInstance();
        //log.info("<--- Start test xxx --->");
    }

    @AfterEach
    public void tearDownAfterEach() {
        driver.quit();
        //log.info("<--- Test suite finished --->");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        log.info("<--- Test suite finished --->");
    }
}
