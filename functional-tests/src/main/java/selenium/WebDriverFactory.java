package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("selenium.implicit.timeout");

    public WebDriverFactory() {
    }

    /**
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     * SetUp grid : browserName, browserVersion, platform.
     *
     * @return WebDriver
     * @setBrowserAndVersion
     * @setPlatform
     */
    public static WebDriver getInstance() {
        log.info(" <--- Start work WebDriver Factory --->");

        setUpChromeDriverPath();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("start-maximized");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(
                Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        log.info("Screen resolution - " + webDriver.manage().window().getSize());

        return webDriver;
    }

    private static void setUpChromeDriverPath() {
        String currentOs = System.getProperty("os.name");
        System.out.println(currentOs);
        System.out.println(currentOs.contains(WINDOWS));
        System.out.println(new File("drivers").getAbsolutePath() + "\\chromedriver_win\\chromedriver");

        if ((currentOs).toLowerCase().contains("linux")) {
            System.setProperty("webdriver.chrome.driver",
                    "\\chromedriver_linux\\chromedriver");
        } else if ((currentOs).toLowerCase().contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "\\chromedriver_mac\\chromedriver");
        } else if ((currentOs).toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver",
                    new File("drivers").getAbsolutePath()
                            + "\\chromedriver_win\\chromedriver.exe");
        } else {
            fail("Unsupported operating system type");
        }
    }
}
