package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.controller.MainControllerTime;
import company.db.AppDb;
/*import company.model.Employee;
import company.notifier.MyListener;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;*/

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactory {

    public static MainController create(boolean withProfiling){
        MainController mainController = new MainControllerImpl(new AppDb());
        return withProfiling ? new MainControllerTime(mainController) : mainController;
    }

}
