package company.utils.reflection;

/**
 * Created by serhii on 27.01.18.
 */
public class ReflectionUtils {


    public static String getMethodName(){
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.getStackTrace()[1].getMethodName();
        }
    }

    public static void main(String[] args) {
        System.out.println(getMethodName());
    }


}
