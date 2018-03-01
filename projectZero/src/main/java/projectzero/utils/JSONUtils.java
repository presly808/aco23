package projectzero.utils;

import com.google.gson.Gson;
import projectzero.model.Order;
import projectzero.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JSONUtils {

    private static Gson gson = new Gson();

    public static<T> T  fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }


    /**
     * Reading from Json file
     *
     * @param path - path of Json file
     * @return list of stmth in Json file
     */
    public static <T> List<T> readAllFromFile(String path, Class<T> objClass) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream().map(line -> gson.fromJson(line, objClass)).collect(Collectors.toList());
    }

    /**
     * Write a list of any objects into Json file
     *
     * @param path  - path of Json file
     * @param list - list of adding objects
     */
    public static void writeListIntoFile(String path, List<?> list) {
        File file = new File(path);
        try (Writer writer = new FileWriter(file, false)) {
            for (Object o : list) {
                writer.write(gson.toJson(o));
                writer.write('\n');
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
