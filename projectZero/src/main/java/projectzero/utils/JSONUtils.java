package projectzero.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class JSONUtils {

    private static Gson gson = new Gson();

    public static<T> T  fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }


    /**runAsync
     * Reading from Json file
     *
     * @param path - path of Json file
     * @return list of stmth in Json file
     */
    public static <T> List<T> readAllFromFile(String path, Class<T> objClass) throws IOException {
        // todo read all by one try, do not parse by lines
        return Files.readAllLines(Paths.get(path)).stream().map(line -> gson.fromJson(line, objClass)).collect(Collectors.toList());
    }

    /**
     * Write a list of any objects into Json file
     *
     * @param path  - path of Json file
     * @param list - list of adding objects
     */
    public static void writeListIntoFile(String path, List<?> list) {
        try (Writer writer = new FileWriter(path, false)) {
            for (Object o : list) {
                writer.write(gson.toJson(o));
                writer.write('\n');
                writer.flush();
            }
        } catch (IOException e) {
            // todo logger
            e.printStackTrace();
        }
    }
}
