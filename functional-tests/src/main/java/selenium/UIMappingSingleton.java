package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.gen5.api.Assertions.fail;

/*
 *  That class provides static methods for getting values from UIMapping.properties and uiMapping MAP
 */
public class UIMappingSingleton {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private volatile static Map<String, String> uiMapping;
    private static UIMappingSingleton uniqueInstance;
    private static Properties properties;

    private UIMappingSingleton() {
        uiMapping = new HashMap<>();
        properties = new Properties();

        loadDataFromUIMappingFile();
        properties.forEach((key, value) -> uiMapping.put((String) key, (String) value));
        log.info("\t*** UIMappingSingleton was created ***");
    }

    public static synchronized UIMappingSingleton getInstance() {
        if (uiMapping == null) {
            log.info("\t*** UIMappingSingleton getInstance() class A ***");
            uniqueInstance = new UIMappingSingleton();
            log.info("\t*** Object - " + uniqueInstance + " ***");
            return uniqueInstance;
        }
        log.info("\t*** UIMappingSingleton getInstance() class B ***");
        log.info("\t*** Object - " + uniqueInstance + " ***");
        return uniqueInstance;
    }

    /**
     *  This method Load locators data from uiMapping.properties which
     *  path is specified in application.properties with key: #uiMappingFile.
     *  Return value from .properties file
     *
     *  @return properties
     */
    public static Properties loadDataFromUIMappingFile() {
        File file = new File(PropertyLoader.loadProperty("uiMappingFile"));

        if (file.exists()) {
            try {
                properties.load(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            } catch (IOException e) {
                fail("Can not find UIMappingFile in class path!");
            }
        }

        return properties;
    }

    /**
     *  This method parses data from UIMapping HashMap
     *
     *  @return By class data type with locatorType and locatorValue
     */
    public static By ui(String key) {
        String[] partsOfLocators = uiMapping.get(key).split("\"");
        String locatorType = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String locatorValue = partsOfLocators[1];

        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "cssSelector":
                return By.cssSelector(locatorValue);

            default:
                fail("Incorrect locator name");
        }
        return null;
    }
}
