package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.controller.MainControllerProxy;
import company.db.AppDb;

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactory {


    public static MainController create(boolean withProfiling){

        return new MainControllerProxy(new MainControllerImpl(new AppDb()));
    }

}
