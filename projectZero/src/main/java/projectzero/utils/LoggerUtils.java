package projectzero.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtils {

    public static void logInfo(String massage) {
        Logger logger = Logger.getLogger("MyLog");
        String path = "projectZero/src/main/test.log";
        FileHandler fh = null;
        try {
            fh = new FileHandler(path, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This block configure the logger with handler and formatter

        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        // the following statement is used to log any messages
        //todo - fix info on log massages
        logger.info(massage);
        fh.close();

    }
}


