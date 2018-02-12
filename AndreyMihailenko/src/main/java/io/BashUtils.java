package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {

        File f = new File(path);

        if (!f.exists() || f.isDirectory()) {
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
        } catch (IOException e) {
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
        if (listOfFiles != null) {
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
        if (src != null) {
            String buff = cat(src);
            return writeInto(dest, buff, true);
        }
        throw new Exception();
    }

    public static boolean move(String src, String dest) throws Exception {
        boolean res = copy(src, dest);
        new File(src).delete();
        return res;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }
        return findR(new File(path), targetName);
    }

    public static List<String> findR(File file, String targetName) {
        List<String> res = new ArrayList<>();
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                res.addAll(findR(f, targetName));
            } else if (f.getName().contains(targetName)) {
                res.add(f.getName());
            }
        }
        return res;
    }

    public static List<String> grep(String lines, String targetWord) {
        return Arrays.stream(lines.split("\n")).filter(line -> line.contains(targetWord))
                .collect(Collectors.toList());
    }

    public static Map<String, String> grepR(String path, String targetWord) throws FileNotFoundException {
        File file = new File(path);
        Map<String, String> map = new HashMap<>();
        if (file.isDirectory()) {
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
