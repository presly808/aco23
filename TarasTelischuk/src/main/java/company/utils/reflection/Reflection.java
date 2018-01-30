package company.utils.reflection;

public class Reflection {

    public static String getMethodName(int id) {

        return Thread.currentThread().getStackTrace()[id].getMethodName();
    }

}
