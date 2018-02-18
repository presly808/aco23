package htmljs;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.WebDriverFactory;
import server.SparkServer;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 17.02.18.
 */
public class TestHtmlJs {

    public static final String HOST = "http://localhost:9898";
    private static SparkServer sparkServer;
    private static WebDriver webDriver;

    @BeforeClass
    public static void initServerAndServeHtmlFiles(){
        String file = TestHtmlJs.class.getResource("task1.html").getFile();
        File parentFile = new File(file).getParentFile();
        sparkServer = new SparkServer(9898, parentFile.getPath());
        webDriver = WebDriverFactory.getInstance();
    }

    @AfterClass
    public static void stopServer(){
        sparkServer.stopServer();
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

//        Thread.sleep(1000);

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

    @Test
    public void testTask3() throws InterruptedException {
        webDriver.navigate().to(HOST + "/task3.html");

//        Thread.sleep(1000);

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
