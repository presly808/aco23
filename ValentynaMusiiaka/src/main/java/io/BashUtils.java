package io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        try {

            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }

            FileReader fileReader = new FileReader(path);
            BufferedReader buffReader = new BufferedReader(fileReader);

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = buffReader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            buffReader.close();
            return sb.toString();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            throw ex;
        } catch (IOException ex) {
            System.out.println("Java IO exception");
        }
        return null;
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);


            buffWriter.write(src);
            buffWriter.flush();
            buffWriter.close();

            return true;


        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            throw ex;
        } catch (IOException ex) {
            System.out.println("Java IO Exception");
        }
        return false;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File directory = new File(path);
        File[] dirFiles = directory.listFiles();

        List<String> dirList = new ArrayList<>();

        for (File dirFile : dirFiles) {
            dirList.add(dirFile.getName());
        }

        return dirList;
    }

    public static boolean copy(String src, String dest) throws Exception {
        try {
            File srcFile = new File(src);

            if (!srcFile.exists()) {
                throw new FileNotFoundException("File not found");
            }

           return writeInto(dest, cat(src), false);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            throw ex;
        }
    }

    public static boolean move(String src, String dest) throws Exception {
        try {
            boolean fileCopied = copy(src, dest);

            if(fileCopied) {
                File oldFile = new File(src);
                return oldFile.delete();
            }

            return false;

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            throw ex;
        }
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {


        File currDir = new File(path);

        List<String> found = new ArrayList<>();
        if (currDir.isFile()) {

            if (currDir.getName().contains(targetName)) {
                found.add(currDir.getAbsolutePath());
            }

            return found;
        }

        File[] dirFiles = currDir.listFiles();

        for (File f : dirFiles) {
            found.addAll(find(f.getPath(), targetName));
        }

        return found;
    }

    public static List<String> grep(String lines, String targetWord) {
        String[] linesSplit = lines.split("\n");
        List<String> linesArr = Arrays.asList(linesSplit);

        return linesArr.stream().filter(s -> s.equals(targetWord)).collect(Collectors.toList());
    }

    public static Map<String, String> grepR(String path, String targetWord) throws IOException, FileNotFoundException {

        File currPath = new File(path);
        Map<String, String> matchMap = new HashMap<>();

        if (currPath.isFile()) {

            String fileContent = cat(path);
            String[] linesSplit = fileContent.split("\n");

            for (int i = 1; i < linesSplit.length; i++) {

                if (linesSplit[i].equals(targetWord)) {

                    matchMap.put(path, targetWord);
                    break;
                }
            }
            return matchMap;
        }

        File[] dirFiles = currPath.listFiles();

        for (File d : dirFiles) {
            matchMap.putAll(grepR(d.getPath(), targetWord));
        }

        return matchMap;

    }
}
