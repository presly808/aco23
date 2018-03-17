package utils;

import org.apache.log4j.Logger;

public class Log4JApp {

    private final static Logger LOGGER = Logger.getLogger(Log4JApp.class);

    public static Logger getLogger(Class classForLogging) {
        return Logger.getLogger(classForLogging);
    }

    /*public static void main(String[] args) throws InterruptedException {
        while (true) {
            LOGGER.debug("I'm doing science and I'm still alive.");
            LOGGER.info("I feel fantastic and I'm still alive.");
            LOGGER.warn("While you're dying I'll be still alive.");
            LOGGER.error("And when you're dead I will be, still alive.");
            LOGGER.fatal("Still alive, still alive.");
            Thread.sleep(1000);
        }
    }*/

}