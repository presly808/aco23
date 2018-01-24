package company.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {

    public static int genId() {
        return (int)(Math.random()*1000);
    }
}
