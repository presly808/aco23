package company.utils;

import java.util.Random;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {
    public static int genId() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
