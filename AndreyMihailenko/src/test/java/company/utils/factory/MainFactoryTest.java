package company.utils.factory;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.model.Employee;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 27.01.18.
 */
public class MainFactoryTest {

    private static final int COUNT = 1_000_000;

    @Test
    public void create(){
        MainController mainController = MainFactory.create(true);

        Assert.assertThat(mainController.getClass(), CoreMatchers.not(MainControllerImpl.class));

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

        Assert.assertNotEquals(employee.getId(), 0);
        Assert.assertNotEquals(employee1.getId(), 0);
        Assert.assertNotEquals(employee2.getId(), 0);
    }

    @Test
    public void testListener() {
        MainController mainController = MainFactory.create(true);

        List<Boolean> booleanList = new ArrayList<>(1);
        booleanList.add(false);

        int salary = (int) (Math.random() * 5000) + 1000;
        Employee saved = mainController.addEmployee(new Employee(String.valueOf("test"),salary));

        mainController.addListener(obj -> {
            System.out.println("event has been occurred");
            Assert.assertThat(obj, CoreMatchers.notNullValue());
            Assert.assertThat(obj.getPlace(), CoreMatchers.containsString("Controller"));
            Assert.assertThat(obj.getPlace(), CoreMatchers.containsString("fireWorker"));
            Assert.assertThat(obj.getDate().toString(),
                    CoreMatchers.containsString(String.valueOf(LocalDateTime.now().getMinute())));

            booleanList.set(0,true);
        });

        mainController.fireWorker(saved.getId());
        Assert.assertThat(booleanList.get(0), CoreMatchers.equalTo(true));

    }

}