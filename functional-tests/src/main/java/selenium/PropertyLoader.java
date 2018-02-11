package selenium;

import java.io.IOException;
import java.util.Properties;

import static org.junit.gen5.api.Assertions.fail;

public class PropertyLoader {

    private static final String PROPERTY_FILE = "/application.properties";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            fail("Incorrect property name - " + name);
        }
        return props.getProperty(name);
    }
}
