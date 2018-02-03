package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.controller.MainControllerProfiling;
import company.db.AppDb;

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactory {

    public static MainController create(boolean withProfiling){
        return new MainControllerProfiling(new MainControllerImpl(new AppDb()));
    }

}
