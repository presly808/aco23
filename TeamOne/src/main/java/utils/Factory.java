package utils;

import appDb.AppDbImpl;
import controller.MainController;
import controller.MainControllerImpl;


// todo rename factory, give more readable name
public class Factory {

    public static MainController create(boolean withProfiling, AppDbImpl appDb) {
            return new MainControllerImpl(appDb);
    }
}

