package company.utils.reflection;

public class Reflection {

    public static String getMethodName(int id) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (id + 1  < 0 || id + 1 >= stackTraceElements.length) {
            return "no such id";
        }
        return stackTraceElements[1 + id].getClassName() + ":" + stackTraceElements[1 + id].getMethodName();
        //return Thread.currentThread().getStackTrace()[id].getMethodName();

    }

}
