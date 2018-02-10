package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        File folder = new File("/home/oleh/folder/");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
        return listOfFiles.toString();
        //return Files.walk(Path.get(path)).filter(Files::isRegularFile).forEach(System.out::println);
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        try (Writer writer = new FileWriter(path,append)){
            writer.write(src);
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File root = new File( path );
        File[] files = root.listFiles().;

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
