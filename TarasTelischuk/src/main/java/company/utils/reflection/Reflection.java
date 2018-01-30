package company.utils.reflection;

public class Reflection {

    public static String getMethodName(int level) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (level + 2 < 0 || level + 2 >= stackTraceElements.length)
            return "no such level";
        return stackTraceElements[2 + level].getClassName() + ":" + stackTraceElements[2 + level].getMethodName();
    }
}
