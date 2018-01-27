package company.utils.factory;

import company.controller.MainController;
import company.model.Employee;
import company.notifier.MyEvent;
import company.notifier.MyListener;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactoryTest {

    public static final int COUNT = 1_000_000;

    @Test
    public void create() throws Exception {
        MainController mainController = MainFactory.create(true);


        Employee first = null;
        Employee last = null;
        Employee mid = null;
        for (int i = 0; i < COUNT; i++) {
            int salary = (int) (Math.random() * 5000) + 1000;
            if(i == 0){
                first = mainController.addEmployee(new Employee(String.valueOf(i),salary));
            }

            if(i == COUNT / 2){
                mid = mainController.addEmployee(new Employee(String.valueOf(i), salary));
            }

            if(i == COUNT - 1){
                last = mainController.addEmployee(new Employee(String.valueOf(i), salary));
            }


        }


        Employee employee = mainController.getById(first.getId());
        Employee employee1 = mainController.getById(last.getId());
        Employee employee2 = mainController.getById(mid.getId());






    }

    @Test
    public void testListener() throws Exception {
        MainController mainController = MainFactory.create(true);


        int salary = (int) (Math.random() * 5000) + 1000;
        Employee saved = mainController.addEmployee(new Employee(String.valueOf("test"),salary));

        mainController.addListener(new MyListener() {
            @Override
            public void eventOccur(MyEvent obj) {
                System.out.println("event has been occurred");
                Assert.assertThat(obj, CoreMatchers.notNullValue());
                Assert.assertThat(obj.getPlace(), CoreMatchers.containsString("Controller"));
                Assert.assertThat(obj.getPlace(), CoreMatchers.containsString("fireWorker"));
                Assert.assertThat(obj.getDate().toString(),
                        CoreMatchers.containsString(String.valueOf(LocalDateTime.now().getMinute())));
                Assert.assertThat(obj, CoreMatchers.notNullValue());
            }
        });

        mainController.fireWorker(saved.getId());

    }

}