package utils;

import appDb.AppDb;
import controller.MainController;
import controller.MainControllerImpl;
import proxy.MainControllerProxy;

public class Factory {

    public static MainController create(boolean withProfiling, AppDb appDb) {
        if (withProfiling) {
            return new MainControllerProxy(new MainControllerImpl(appDb));
        } else {
            return new MainControllerImpl(appDb);
        }
    }
}
