package company.utils;

import company.db.AppDb;

/**
 * Created by serhii on 20.01.18.
 */
public class MyUtils {
    public static int genId() {
        return (int)(Math.random()*100);
    }
}
