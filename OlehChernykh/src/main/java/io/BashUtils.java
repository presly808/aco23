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
        try{
            File file = new File(path);
            if(!file.exists()){
                throw new FileNotFoundException(path);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Reader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];

        int count = -1;
        try {
            while ((count = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, count);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();

        //return Files.walk(Path.get(path)).filter(Files::isRegularFile).forEach(System.out::println);
    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        try (Writer writer = new FileWriter(path, append)){
            writer.write(src);
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File dir = new File(path);
        File[] files = dir.listFiles();
        List<String> list = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() || file.isDirectory()) {
                    list.add(file.getName());
                }
            }
            return list;
        }
        throw new FileNotFoundException() ;
    }

    public static boolean copy(String src, String dest) throws Exception {
        if (src != null){
            String buffer = cat(src);
            writeInto(dest,buffer,true);
            return true;
        }
        throw new Exception();
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
