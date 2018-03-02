package projectzero.utils;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtils {

    static {
        PropertyConfigurator.configure(LogUtils.class.getResource("/log4j.properties"));
    }

    /**
     * @param classForLogging - class which will logged
     * @return Logger for current class
     */
    public static Logger getLogger(Class classForLogging) {
        return Logger.getLogger(classForLogging);
    }
}
