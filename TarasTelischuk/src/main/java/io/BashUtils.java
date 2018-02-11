package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }
        File file = new File(path);
            if (file.isDirectory()) {
               return Arrays.stream(file.listFiles()).map(File::getName).collect(Collectors.toList());

        }
        return null;
    }

    public static boolean copy(String src, String dest) throws Exception {
       InputStream in = new FileInputStream(new File(src));
       OutputStream out = new FileOutputStream(new File(dest));

       try{
           byte[] buff = new byte[1024];
           int count ;
           while((count = in.read(buff)) != -1 ){
                out.write(buff, 0, count);
                out.flush();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return true;
    }

    public static boolean move(String src, String dest) throws  Exception{
        copy(src, dest);
        boolean res;
        File file = new File(src);
        res = file.delete();
        return res;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException{
        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }
        File file = new File(path);
        return findR(file, targetName);
    }

    public static List<String> grep(String lines, String targetWord){
        return Arrays.stream(lines.split("\n")).sorted().filter(line -> line.contains(targetWord)).collect(Collectors.toList());
    }

    public static Map<String, String> grepR(String path, String targetWord){
        return null;
    }



    private static List<String> findR(File file, String targetName){
    List<String> list = new ArrayList<>();
    Arrays.stream(file.listFiles()).forEachOrdered(f -> {
        if (f.isDirectory()) {
            list.addAll(findR(f, targetName));
        } else {
            if (f.getName().contains(targetName)) {
                list.add(f.getName());
            }
        }
        });
        return list;
    }

}
