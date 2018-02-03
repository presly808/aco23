package company.utils.reflection;

public class ReflectionUtils {

    public static String getMethodName(int id){
        return Thread.currentThread().getStackTrace()[id].getMethodName();
    }
}
