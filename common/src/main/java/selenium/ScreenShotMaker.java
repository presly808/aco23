package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShotMaker {

    private static WebDriver driver;
    private static String screenShotDirectory;

    public ScreenShotMaker(WebDriver driver)
    {
        this.driver = driver;
        screenShotDirectory = ".";

        File scrDir = new File(screenShotDirectory);
        if (!scrDir.exists()) scrDir.mkdirs();
    }

    public static void getScreenShot(String fileName) {
        try {
            setUpScreenShotMaker(screenShotDirectory, fileName);
            System.out.println("Make screenshot " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void setUpScreenShotMaker(String screenShotDirectory, String aaa) throws IOException {
        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String dateNow = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss")
                .format(Calendar.getInstance().getTime())
                .replace("/", "_")
                .replace(":", "_");

        File file = new File(screenShotDirectory + dateNow);

        if (!file.exists()) file.mkdir();

        String path = file.getAbsolutePath() + "/" + aaa + "/" + source.getName();
        FileUtils.copyFile(source, new File(path));
    }
}
