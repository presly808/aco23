package io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {
    public static String cat(String path) throws FileNotFoundException {
        checkFileExists(path);

        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new FileReader(path);
            char[] buff = new char[100000];
            while (reader.read(buff) != -1)
                sb.append(buff);
        } catch (IOException ignored) {
        }

        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(path, append));
        boolean flag = true;

        try {
            writer.write(src);
            writer.flush();
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File file = checkFileExists(path);

        if (file.isDirectory())
            return Arrays.stream(file.listFiles())
                    .map(File::getName).collect(Collectors.toList());
        return null;
    }

    public static boolean copy(String src, String dest) throws Exception {
        try (InputStream input = new FileInputStream(new File(src).getAbsolutePath());
             OutputStream output = new FileOutputStream(new File(dest).getAbsolutePath())) {
            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0)
                output.write(buf, 0, bytesRead);
        }
        return true;
    }

    public static boolean move(String src, String dest) throws Exception {
        return copy(src, dest) && new File(src).delete();
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        checkFileExists(path);
        List<String> list = new ArrayList<>();
        getFilesRecursion(path, list);

        return list.contains(targetName) ? Collections.singletonList(targetName) : null;
    }

    private static File checkFileExists(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException();

        return file;
    }

    private static void getFilesRecursion(String path, List<String> list) {
        for (File f: new File(path).listFiles())
            if (f.isDirectory()) getFilesRecursion(f.getAbsolutePath(), list);
            else list.add(f.getName());
    }

    public static List<String> grep(String lines, String targetWord) {
        if (Arrays.asList(lines.split("\n")).contains(targetWord))
            return Collections.singletonList(targetWord);

        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        getFilesRecursion(path, list);

        for (String filePaths: list)
            if (grep(cat(String.valueOf(Paths.get(path))), targetWord) != null)
                map.put(filePaths, String.valueOf(grep(cat(filePaths), targetWord)));

        return map;
    }
}
