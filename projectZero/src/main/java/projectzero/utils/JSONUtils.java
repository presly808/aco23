package projectzero.utils;

import com.google.gson.Gson;
import projectzero.model.Order;
import projectzero.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONUtils {

    private static Gson gson = new Gson();

    // TODO: 24-Feb-18 Ask Serhii for generify
    // TODO: 24-Feb-18 Orders

    public static<T> T  fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    /**
     * Add User to Json file
     *
     * @param path - path of Json file
     * @param user - adding user
     * @throws IOException when problems with reading
     */
    public static void addUser(String path, User user) throws IOException {
        List<User> users = readUsersFromFile(path);
        users.add(user);
        writeListIntoFile(path, users);
    }


    /**
     * Remove user from Json file
     *
     * @param path - path of Json file
     * @param user - user which will removed
     * @throws IOException when problems with reading
     */
    public void removeUser(String path, User user) throws IOException {
        List<User> users = readUsersFromFile(path);
        users.remove(user);
        writeListIntoFile(path, users);
    }

    /**
     * Reading from Json file
     *
     * @param path - path of Json file
     * @return list of users in Json file
     * @throws IOException when problems with reading
     */
    @SuppressWarnings("unchecked")
    public static List<User> readUsersFromFile(String path) throws IOException {
        File file = new File(path);
        List<User> list = new ArrayList<>();
        if (file.length() != 0) {
            String jString = new String(Files.readAllBytes(Paths.get(path)));
            Collections.addAll(list, gson.fromJson(jString, User[].class));
        }
        return list;
    }

    public static List<Order> readOrdersFromFile(String path) throws IOException {
        File file = new File(path);
        List<Order> list = new ArrayList<>();
        if (file.length() != 0) {
            String jString = new String(Files.readAllBytes(Paths.get(path)));
            Collections.addAll(list, gson.fromJson(jString, Order[].class));
        }
        return list;
    }

    /**
     * Write a list of any objects into Json file
     *
     * @param path  - path of Json file
     * @param list - list of adding objects
     */
    private static void writeListIntoFile(String path, List<?> list) {
        File file = new File(path);
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(list));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
