package projectzero;

import projectzero.server.Server;
import projectzero.utils.EmailUtils;
import projectzero.utils.LogUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// todo describe in read me how to run server
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter path to a config file as the 1st arg");
            System.exit(-1);
        }

        Properties appProperties = new Properties();
        try (InputStream io = new FileInputStream(args[0])) {
            appProperties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        String pathToLog4jProperties = appProperties.getProperty("pathToLog4jProperties");
        LogUtils.configLogger(pathToLog4jProperties);


        String pathToMailProperties = appProperties.getProperty("pathToMailProperties");

        Properties mailProperties = new Properties();
        try (InputStream io = new FileInputStream(pathToMailProperties)) {
            mailProperties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        EmailUtils.setProps(mailProperties);

        String pathToUsersJSON = appProperties.getProperty("pathToUsersJSON");
        String pathToOrdersJSON = appProperties.getProperty("pathToOrdersJSON");

        new Server(9817, pathToUsersJSON, pathToOrdersJSON);
    }
}
