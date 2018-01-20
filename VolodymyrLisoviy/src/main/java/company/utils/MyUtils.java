package company.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {

    private static Random random = new SecureRandom();

    public static int genId() {
        return random.nextInt();
    }
}
