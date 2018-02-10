package io;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        StringBuilder sb = new StringBuilder();
        try(Reader reader = new FileReader(path)) {
            int count;
            char[] buf = new char[1024];
            while((count = reader.read(buf)) != -1) {
                sb.append(buf, 0, count);
            }
        }
        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        try(Writer writer = new FileWriter(path, append)) {
            writer.write(src);
            writer.flush();
        }
        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.isDirectory()) {
            return Arrays.stream(file.listFiles()).map(File::getName).collect(Collectors.toList());
        }
        return null;
    }

    public static boolean copy(String src, String dest) throws Exception {
        File source = new File(src);
        File copy = new File(dest);

        try(InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(copy)) {
            int count;
            byte[] buf = new byte[1024];
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
                os.flush();
            }
        }

        return true;
    }

    public static boolean move(String src, String dest) throws  Exception {
        boolean result = copy(src, dest);
        Files.delete(Paths.get(src));
        return result;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }

        return findR(new File(path), targetName);
    }

    public static List<String> grep(String lines, String targetWord){
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord){
        return null;
    }

    private static List<String> findR(File file, String targetName) {
        List<String> list = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                list.addAll(findR(f, targetName));
            } else {
                if (f.getName().contains(targetName)) {
                    list.add(f.getName());
                }
            }
        }
        return list;
    }
}
