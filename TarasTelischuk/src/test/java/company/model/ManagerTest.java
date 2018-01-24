package company.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import org.junit.Test;


public class ManagerTest {

    @Test
    public void addSubworker(){
        Manager man = new Manager("Andry", 6300);
        Assert.assertThat(man.addSubworker(new Employee("Sveta",4968)),
                CoreMatchers.equalTo(true));
    }

    @Test
    public void getSubworkers(){
        Manager manager = new Manager("Andrey", 3000);

        manager.addSubworker(new Employee("Olya", 7569));
        manager.addSubworker(new Employee("Toma", 4832));
        manager.addSubworker(new Employee("Viktor", 6500));
        manager.addSubworker(new Employee("Taras", 7500));

        Assert.assertThat(manager.getSubworkers().size(), CoreMatchers.equalTo(4));
    }

}