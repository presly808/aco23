package company.utils;

import java.util.Random;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {

    private static Random random = new Random();

    public static int genId() {
        return random.nextInt();
    }

    public static String getMethodName(int level) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        return stackTraceElements[level].getMethodName();
    }
}
