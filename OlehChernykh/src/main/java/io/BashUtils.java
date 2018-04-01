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
        try {
            Files.copy(Paths.get(src), Paths.get(dest));
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        throw new Exception();
    }

    public static boolean move(String src, String dest) throws  Exception{
        try {
            Files.move(Paths.get(src), Paths.get(dest));
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

    public static Map<String, String> grepR(String path, String targetWord) throws FileNotFoundException {
        File file = new File(path);
        Map<String, String> map = new HashMap<>();
        if (file.isDirectory()){
            for (File f : Objects.requireNonNull(file.listFiles())) {
                Map<String, String> bufMap = grepR(f.getPath(), targetWord);
                bufMap.keySet().forEach(key -> map.put(key, bufMap.get(key)));
            }
        } else {
            Optional<String> stream = Arrays.stream(cat(path).split("\n"))
                    .filter(lines -> lines.contains(targetWord)).findFirst();
            stream.ifPresent(str -> map.put(file.getName(), str));
        }

        return map;
    }
}
