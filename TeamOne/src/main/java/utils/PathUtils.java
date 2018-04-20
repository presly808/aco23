package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathUtils {

    private static Properties appProperties = new Properties();
//    private static String pathToProps = "src/main/java/app.properties";
    private static String pathToProps = PathUtils.class.getResource("../app.properties").getFile();
    private static String pathToTestProps = PathUtils.class.getResource("../test.properties").getFile();


    public static String getUsersDbPath() {

        loadProperty(pathToProps);

        return appProperties.getProperty("pathToUsersJSON");
    }

    public static String getOrdersDbPath() {

        loadProperty(pathToProps);

        return appProperties.getProperty("pathToOrdersJSON");
    }

    public static String getLog4jPath() {

        loadProperty(pathToProps);

        return appProperties.getProperty("pathToLog4jProperties");
    }

    public static String getServerPort() {

        loadProperty(pathToTestProps);

        return appProperties.getProperty("SERVER_PORT");
    }

    public static String getServerHost() {

        loadProperty(pathToTestProps);

        return appProperties.getProperty("SERVER_HOST");
    }

    public static String getStaticFolder() {

        loadProperty(pathToTestProps);

        return appProperties.getProperty("STATIC_FOLDER");
    }

    private static void loadProperty (String pathToProps){
        try (InputStream io = new FileInputStream(pathToProps)) {
            appProperties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
