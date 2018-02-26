package projectzero.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtils {

    public static void logInfo(String className) {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            // This block configure the logger with handler and formatter
            String path = "projectZero/src/main/test.log";
            fh = new FileHandler(path, true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            //todo - fix info on log massages
            logger.info("Action was successful in " + "'" + className + "'");

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}


