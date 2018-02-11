package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.controller.MainControllerProfilerProxy;
import company.db.AppDb;

public class MainFactory {
    public static MainController create(boolean withProfiling){
        MainController mainController = new MainControllerImpl(new AppDb());

        return withProfiling ? new MainControllerProfilerProxy(mainController)
                : mainController;
    }
}
