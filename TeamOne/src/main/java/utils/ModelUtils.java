package utils;

import java.util.Random;

public class ModelUtils {

    private static Random random = new Random();

    public static int genId() {
        return random.nextInt();
    }
}
