package projectzero.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyUtils {

    private static SecureRandom random = new SecureRandom();

    public static String getUniqueKey() {
        return new BigInteger(256, random).toString(32);
    }
}
