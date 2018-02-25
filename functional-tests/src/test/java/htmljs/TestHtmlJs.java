package htmljs;

import htmljs.server.TestSparkServer;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.WebDriverFactory;

import java.io.File;
import java.util.List;

/**
 * Created by serhii on 17.02.18.
 */
public class TestHtmlJs {

    public static final int port = 9898;
    public static final String HOST = "http://localhost:" + port;
//    private static SparkStaticResourcesServer sparkServer;
    private static WebDriver webDriver;
    private static TestSparkServer testSparkServer;

    @BeforeClass
    public static void initServerAndServeHtmlFiles(){

        String file = TestHtmlJs.class.getResource("task1.html").getFile();
        File parentFile = new File(file).getParentFile();

        testSparkServer = new TestSparkServer(9898, parentFile.getPath());

        webDriver = WebDriverFactory.getInstance(true);
    }

    @AfterClass
    public static void stopServer(){
        testSparkServer.stopServer();
        webDriver.quit();
    }

    @Test
    public void testTask1() throws InterruptedException {
        webDriver.navigate().to(HOST + "/task1.html");

//        Thread.sleep(1000);

        WebElement addButton = webDriver.findElement(By.cssSelector("#addBut"));

        addButton.click();

        List<WebElement> listItems = webDriver.findElements(By.cssSelector("li"));

        Assert.assertThat(listItems.size(), CoreMatchers.is(2));

    }

    @Test
    public void testTask2() throws InterruptedException {
        webDriver.navigate().to(HOST + "/task2.html");

        WebElement inputSearch = webDriver.findElement(By.cssSelector("#searchWord"));
        WebElement addButton = webDriver.findElement(By.cssSelector("#addBut"));
        WebElement removeButton = webDriver.findElement(By.cssSelector("#remBut"));

        inputSearch.click();

        inputSearch.sendKeys("new line");

        addButton.click();

        List<WebElement> listItems = webDriver.findElements(By.cssSelector("li"));

        Assert.assertThat(listItems.size(), CoreMatchers.is(2));
        Assert.assertThat(listItems.get(1).getText(), CoreMatchers.is("new line"));

        removeButton.click();
        List<WebElement> afterRemList = webDriver.findElements(By.cssSelector("li"));
        Assert.assertThat(afterRemList.size(), CoreMatchers.is(1));

    }

    @Ignore
    @Test
    public void testTask3() throws InterruptedException {
        webDriver.navigate().to(HOST + "/task3.html");


        WebElement inputSearch = webDriver.findElement(By.cssSelector("#searchWord"));
        WebElement addButton = webDriver.findElement(By.cssSelector("#addBut"));

        inputSearch.click();

        inputSearch.sendKeys("new line");

        addButton.click();

        List<WebElement> listItems = webDriver.findElements(By.cssSelector("li"));

        Assert.assertThat(listItems.size(), CoreMatchers.is(2));
        Assert.assertThat(listItems.get(1).getAttribute("value"), CoreMatchers.is("new line"));

    }

}
