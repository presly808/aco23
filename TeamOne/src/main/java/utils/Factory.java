package utils;

import appDb.AppDb;
import controller.MainController;
import controller.MainControllerImpl;
import proxy.MainControllerProxy;

public class Factory {

    public static MainController create(boolean withProfiling) {
        if (withProfiling) {
            return new MainControllerProxy(new MainControllerImpl(new AppDb()));
        } else {
            return new MainControllerImpl(new AppDb());
        }
    }
}

