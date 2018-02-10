package io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        Reader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        char[] buff = new char[10000];

        try{
            while(reader.read(buff) != -1 ){
                sb.append(buff, 0, -1);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(path, append));

        try {
            writer.write(src);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        Reader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        try{
            while(reader.read() != -1){
                result.add(sb.append('\n').toString());
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return result;
    }

    public static List<String> grep(String lines, String targetWord){

        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord){

        return null;
    }
}
