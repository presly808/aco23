package utils;

import com.google.gson.Gson;

public class JSONUtils {

    private static Gson gson = new Gson();

    public static<T> T  fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

}
