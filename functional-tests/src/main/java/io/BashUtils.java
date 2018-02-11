package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        return null;
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        return false;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        return null;
    }

    public static boolean copy(String src, String dest) throws Exception {
        return false;
    }

    public static boolean move(String src, String dest) throws  Exception{
        return false;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException{
        return null;
    }

    public static List<String> grep(String lines, String targetWord){
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord){
        return null;
    }

}
