package projectzero.utils;

import com.google.gson.Gson;
import org.openqa.selenium.json.Json;
import projectzero.model.Employee;
import projectzero.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class JSONUtils {

    /*JSONUtils
    * - void writeIntoFile (path, user)
    * - User findUser ()
    * - List<User> readFromFile (path)
    * -
    * */

    private User user;
    private static Gson gson = new Gson();
    private File employeesFile = new File("Employees.json");
    private File usersFile = new File("Users.json");

    public static void writeIntoFile (String path, User user){
        File file = new File(path);
        if (file.exists() && file.canWrite()){
            try (Writer writer = new FileWriter(file, true)) {
                writer.write(gson.toJson(user));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser (String path){
        return null;
    }

    public List<User> readFromFile (String path) throws IOException {
        String jString = new String(Files.readAllBytes(Paths.get(path)));
        User[] users = gson.fromJson(jString, User[].class);
        List<User> list = new ArrayList<>();
        Collections.addAll(list, users);
        return list;
    }





}
