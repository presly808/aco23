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
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new FileReader(path);
            char[] buff = new char[100000];
            while (reader.read(buff) != -1)
                sb.append(buff);
        } catch (IOException ex){}

        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
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
        File folder = new File(
                new File(path).toURI().relativize(
                        new File(path).toURI()).getPath());
        List<String> list = new ArrayList<>();

        for (File listOfFile : folder.listFiles()) {
            if (listOfFile.isFile())
                list.add(listOfFile.getName());
        }

        return list;
    }

    public static boolean copy(String src, String dest) throws Exception {
        try (InputStream input = new FileInputStream(new File(src).getAbsolutePath());
             OutputStream output = new FileOutputStream(new File(dest).getAbsolutePath())) {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        }

        return true;
    }

    public static boolean move(String src, String dest) throws Exception {
        File file = new File(src);
        file.createNewFile()

        FileUtils.copyFile(src, new File(dest));

        return true;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        Reader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        List<String> result = null;

        try {
            while (reader.read() != -1) {
                result.add(sb.append('\n').toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static List<String> grep(String lines, String targetWord) {

        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord) {

        return null;
    }
}
