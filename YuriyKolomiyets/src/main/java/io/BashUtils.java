package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {

        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException("Could not find file: " + path);
            }
        }

        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

        Reader reader = new FileReader(path);

        StringBuilder stringBuilder = new StringBuilder();

        char[] buffer = new char[1024];

        int count = -1;

        try {
            while ((count = reader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, count);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return String.valueOf(stringBuilder);

    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {

        try (Writer writer = new FileWriter(path, append)) {
            writer.write(src);
            writer.flush();

        } catch (IOException exception){
            exception.printStackTrace();
        }

        return true;

    }

    public static List<String> ls(String path) throws FileNotFoundException {

        File folder = new File(path);

        try {
            if (!folder.exists()) {
                throw new FileNotFoundException("Could not find folder: " + path);
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

        File[] listOfFiles = folder.listFiles();
        List<String> list = new ArrayList<>();

        if (listOfFiles != null){
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    list.add(listOfFile.getName());
                }
            }
            return list;
        }
        throw new FileNotFoundException();
    }

    public static boolean copy(String src, String dest) throws Exception {
        return false;
    }

    public static boolean move(String src, String dest) throws Exception {
        return false;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        return null;
    }

    public static List<String> grep(String lines, String targetWord) {
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord) {
        return null;
    }

}
