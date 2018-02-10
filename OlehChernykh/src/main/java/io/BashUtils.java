package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        String str = "";
        try {
            str = Files.readAllLines(Paths.get(path)).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
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
        Path source = Paths.get(src);
        Path destination = Paths.get(dest);
        try {
            Files.copy(source, destination);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        throw new Exception();
    }

    public static boolean move(String src, String dest) throws  Exception{
        Path source = Paths.get(src);
        Path destination = Paths.get(dest);
        try {
            Files.move(source, destination);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        throw new Exception();
    }
    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        Path start = Paths.get(path);
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            return stream.map(String::valueOf).filter(p -> p.contains(targetName)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException();

    }

    public static List<String> grep(String lines, String targetWord) throws IOException {
        return Arrays.stream(lines.split("\n")).filter(l->l.contains(targetWord)).collect(Collectors.toList());

    }

    public static Map<String, String> grepR(String path, String targetWord){
        File file = new File(path);
        Map<String, String> map = new HashMap<>();
        if (file.isDirectory()){
        }
        return null;
    }

}
