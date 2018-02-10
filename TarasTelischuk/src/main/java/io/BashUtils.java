package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        char[] buff = new char[1024];
        int count ;

        try{
            while((count = reader.read(buff)) != -1 ){
                sb.append(buff,0,count);
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


    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        try{
            Writer writer = new FileWriter(path, append);
            writer.write(src);
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        return Arrays.asList(System.getenv(path).split(":"));
    }

    public static boolean copy(String src, String dest) throws Exception {
        if (src != null){
            String buff = cat(src);
            return writeInto(dest, buff, true);
        }
        return false;
    }

    public static boolean move(String src, String dest) throws  Exception{
        boolean res = copy(src, dest);
        Files.delete(Paths.get(src));
        return res;
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
