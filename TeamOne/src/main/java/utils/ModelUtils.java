package utils;

import java.util.Random;

public class ModelUtils {

    // todo cover case when data will be loaded from the db file and application restarts
    // todo in desribed case you probably have no uniques ids
    private static Random random = new Random();

    public static int genId() {
        return random.nextInt();
    }
}
