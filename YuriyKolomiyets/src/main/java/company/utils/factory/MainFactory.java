package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.db.AppDb;
import company.proxy.MainControllerProxy;

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactory {

    public static MainController create(boolean withProfiling){
        if (withProfiling == true) {
            return new MainControllerProxy(new MainControllerImpl(new AppDb()));
        } else {
            return new MainControllerImpl(new AppDb());
        }
    }
}
