package io;

import java.io.*;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {

        File f = new File(path);

        if(!f.exists() || f.isDirectory()) {
            throw new FileNotFoundException();
        }
        Reader reader = new FileReader(path);
        StringBuilder stringBuilder = new StringBuilder();

        char[] buff = new char[100];
        int count;
        try {
            while ((count = reader.read(buff)) != -1) {
                stringBuilder.append(buff, 0, count);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        try (Writer writer = new FileWriter(path, append)) {
            writer.write(src);
            return true;
        }
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<String> list = new ArrayList<>();
        if (listOfFiles != null){
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile() || listOfFile.isDirectory()) {
                    list.add(listOfFile.getName());
                }
            }
            System.out.println("LS test" + list);
            return list;
        }
        throw new FileNotFoundException();
    }

    public static boolean copy(String src, String dest) throws Exception {
        if (src != null){
            String buff = cat(src);
            return  writeInto(dest, buff, true);
        }
        throw new Exception();
    }

    public static boolean move(String src, String dest) throws  Exception{
        boolean res = copy(src, dest);
        new File(src).delete();
        return res;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException{
        List<String> res = ls(path);
        for (String str : res) {
            if (!str.equals(targetName)){
                res.remove(str);
            }
        }
        return res;
    }

    public static List<String> grep(String lines, String targetWord){
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord){
        return null;
    }

}
