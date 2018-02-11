package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

        boolean ret = false;

        try (Writer writer = new FileWriter(path, append)) {
            writer.write(src);
            writer.flush();
            ret = true;

        } catch (IOException exception){
            exception.printStackTrace();
        }
        return ret;
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
                System.out.println(listOfFile.getName());
                if (listOfFile.isFile()) {
                    list.add(listOfFile.getName());
                }
            }
            return list;
        }
        throw new FileNotFoundException();
    }

    public static boolean copy(String src, String dest) throws Exception {

        String res = "";
        boolean ret = false;
        try {
            res = res +  cat(src);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

        try {
            ret = writeInto(dest, res, false);
        } catch (IOException exception){
            exception.printStackTrace();
        }

        return ret;
    }

    public static boolean move(String src, String dest) throws Exception {

        boolean ret = false;
        try {
            copy(src, dest);
            File file = new File(src);
            ret = file.delete();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {

        if (!Files.exists(Paths.get(path))) {
            throw new FileNotFoundException();
        }

        return findRec(new File(path), targetName);

    }

    public static List<String> grep(String lines, String targetWord) {
       return Arrays.asList(lines.split("\n")).stream()
                .filter(line -> line.contains(targetWord)).collect(Collectors.toList());
    }

    public static Map<String, String> grepR(String path, String targetWord) {


        /*Map<String, String> ret = new HashMap<>();
        List<String> grepRes = new ArrayList<>();

        try {
            String fileSource = cat(path);
            String fileName =
            grepRes = grep(fileSource, targetWord);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */



        return null;
    }

    private static List<String> findRec(File file, String targetName) {

        List<String> ret = new ArrayList<>();

        // if folder -> go inside

        Arrays.stream(file.listFiles()).forEach(oneFile -> {
            if (oneFile.isDirectory()) {
                ret.addAll(findRec(oneFile, targetName));

                // if file -> check & add to list

            } else if (oneFile.getName().contains(targetName)) {
                ret.add(oneFile.getName());
            }
        });
        return ret;
    }



}
