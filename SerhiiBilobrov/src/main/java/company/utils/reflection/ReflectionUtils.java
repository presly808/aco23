package company.utils.reflection;

/**
 * Created by serhii on 27.01.18.
 */
public class ReflectionUtils {


    public static String getMethodName(int id){
        return Thread.currentThread().getStackTrace()[id].getMethodName();
    }

}
