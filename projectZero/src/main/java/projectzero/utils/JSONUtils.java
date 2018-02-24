package projectzero.utils;

import com.google.gson.Gson;
import projectzero.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONUtils {

    private static Gson gson = new Gson();

    /**
     * Add User to Json file
     *
     * @param path - path of Json file
     * @param user - adding user
     * @throws IOException
     */
    public static void addUser(String path, User user) throws IOException {
        List<User> users = readFromFile(path);
        users.add(user);
        writeListIntoFile(path, users);
    }

    /**
     * Write a list of users into Json file
     *
     * @param path  - path of Json file
     * @param users - list af adding users
     */
    private static void writeListIntoFile(String path, List<User> users) {
        File file = new File(path);
        try (Writer writer = new FileWriter(file, false)) {
            writer.write(gson.toJson(users));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path - path of Json file
     * @param email - incoming email
     * @return - User with incoming email
     * @throws IOException
     */
    public static User findUserByEmail(String path, String email) throws IOException {
        List<User> users = readFromFile(path);
        return null;
    }

    /**
     * Remove user from Json file
     *
     * @param path - path of Json file
     * @param user - user which will removed
     * @throws IOException
     */
    public void removeUser(String path, User user) throws IOException {
        List<User> users = readFromFile(path);
        users.remove(user);
        writeListIntoFile(path, users);
    }

    /**
     * Reading from Json file
     *
     * @param path - path of Json file
     * @return list of users in Json file
     * @throws IOException
     */
    public static List<User> readFromFile(String path) throws IOException {
        File file = new File(path);
        List<User> list = new ArrayList<>();
        if (file.length() != 0) {
            String jString = new String(Files.readAllBytes(Paths.get(path)));
            User[] users = gson.fromJson(jString, User[].class);
            Collections.addAll(list, users);

            return list;
        }
        return list;
    }

}
