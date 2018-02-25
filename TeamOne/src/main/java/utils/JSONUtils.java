package utils;

import com.google.gson.Gson;
import model.Order;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONUtils {

    private static Gson gson = new Gson();

    public static<T> T  fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static void addUser(String path, User user) throws IOException {
        List<User> users = getUsersFromDb(path);
        users.add(user);
        saveUserToDb(path, users);
    }

    private static void saveUserToDb(String path, List<User> users) {
        File file = new File(path);
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(users));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> getUsersFromDb(String path) throws IOException {

        File file = new File(path);
        List<User> list = new ArrayList<>();

        if (file.length() != 0) {
            String jString = new String(Files.readAllBytes(Paths.get(path)));
            Collections.addAll(list, gson.fromJson(jString, User[].class));
        }
        return list;
    }

}
