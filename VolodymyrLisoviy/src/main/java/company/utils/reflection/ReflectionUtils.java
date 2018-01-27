package company.utils.reflection;

public class ReflectionUtils {

    public static String getMethodName(){
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.getStackTrace()[1].getMethodName();
        }
    }
}
