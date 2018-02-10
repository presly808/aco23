package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        Reader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        int count;

        try{
            while((count = reader.read()) != -1 ){
                sb.append(count);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        return false;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        return Arrays.asList(System.getenv(path).split(":"));
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
