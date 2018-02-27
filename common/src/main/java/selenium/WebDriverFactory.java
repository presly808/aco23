package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static final String IMPLICIT_WAIT = "5";

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
    public static WebDriver getInstance(boolean showBrowser) {
        System.out.println(" <--- Start work WebDriver Factory --->");

        setUpChromeDriverPath();

        ChromeOptions chromeOptions = new ChromeOptions();

        if(!showBrowser){
            chromeOptions.addArguments("--headless");
        }
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
        System.out.println("Screen resolution - " + webDriver.manage().window().getSize());

        return webDriver;
    }

    private static void setUpChromeDriverPath() {
        String currentOs = System.getProperty("os.name");

        String lowerCaseOsName = currentOs.toLowerCase();

        String seleniumDriversPath = "../common/drivers";

        if (lowerCaseOsName.contains("linux")) {
            System.setProperty("webdriver.chrome.driver",
                    new File( seleniumDriversPath + "/chromedriver_linux/chromedriver").getAbsolutePath());
        } else if (lowerCaseOsName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    new File( seleniumDriversPath + "/chromedriver_mac/chromedriver").getAbsolutePath());

        } else if (lowerCaseOsName.contains("windows")) {
            System.setProperty("webdriver.chrome.driver",
                    new File( seleniumDriversPath + "/chromedriver_win/chromedriver.exe").getAbsolutePath());

        } else {
            throw new AssertionError("Unsupported operating system type");
        }
    }
}
