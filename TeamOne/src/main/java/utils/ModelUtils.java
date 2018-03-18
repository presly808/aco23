package utils;

import model.User;

import java.io.IOException;
import java.util.List;


// todo save with the last id into json
public class ModelUtils {

    // todo cover case when data will be loaded from the db file and application restarts

    private static int id;

    private static int getMaxIdInDb() {
        List<User> users = null;
        try {
            users = JSONUtils.getUsersFromDb("user_db.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users != null ? users.stream()
                .max((user1, user2) -> (Integer.compare(user1.getId(), user2.getId())))
                .get().getId() : 0;
    }

    public static int genId() {
        return  (int)(Math.random() * 50000);
    }

    public static int genUserId() {
        int maxIdInDb = getMaxIdInDb();
        if (id < maxIdInDb) {
            return id = maxIdInDb+1;
        } else {
            return id++;
        }
    }
}