package company.utils;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {

    public static int genId() {
        return (int) (Math.random() *100);
    }

    public static String getMethodName(int level) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        return stackTraceElements[level].getMethodName();
    }
}
