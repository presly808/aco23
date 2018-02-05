package java8.groupbyagg;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8UtilsTest {

    private List<User> userList;

    @Before
    public void before(){
        userList = new ArrayList<>();

        Department it = new Department(1,"IT","KIEV");
        Department support = new Department(2,"SUPPORT","KIEV");
        Department test = new Department(3,"TEST","ODESSA");
        Department man = new Department(4,"MAN","ODESSA");


        userList.add(new User(1,"Kolia", 3000, it));
        userList.add(new User(2,"Oleg", 2000, test));
        userList.add(new User(3,"Ivan", 5000, it));
        userList.add(new User(4,"Olesia", 1000, support));
        userList.add(new User(5,"Petro", 2500, test));
        userList.add(new User(6,"Jenia", 3500, support));
    }

    @After
    public void after(){
        userList = null;
    }


    @Test
    public void topBySalaryWithLimit() throws Exception {
        List<User> res = Java8Utils.topBySalaryWithLimit(userList,2);
        assertThat(res.size(), is(2));
        assertThat(res.get(0).money, equalTo(5000.0));
        assertThat(res.get(1).money, equalTo(3500.0));
    }

    @Test
    public void groupByDepartment() throws Exception {
        Map<Department, List<User>> departmentListMap = Java8Utils.groupByDepartment(userList);


        assertThat(departmentListMap.keySet().size(), equalTo(3));
        assertThat(departmentListMap.get(new Department(1,"","")).size(),
                equalTo(2));
        assertThat(departmentListMap.values().stream().flatMap(List::stream).collect(Collectors.toList()),
                equalTo(6));
    }

    @Test
    public void groupByDepartmentWithSumOfSalaries() throws Exception {
        Map<Department, Double> departmentDoubleMap = Java8Utils.groupByDepartmentWithSumOfSalaries(userList, 2);
        assertThat(departmentDoubleMap.get(new Department(1,"","")),
                equalTo(8000.0));

    }

    @Test
    public void groupByCityName() throws Exception {
        Map<String, List<User>> stringListMap = Java8Utils.groupByCityName(userList);
        assertThat(stringListMap.keySet().size(), equalTo(2));
        assertThat(stringListMap.get("KIEV").size(), equalTo(4));
    }

    @Test
    public void amountOfAllSalariesUsingReduce() throws Exception {
        Double aDouble = Java8Utils.amountOfAllSalariesUsingReduce(userList);
        assertEquals(17000,aDouble,0);

    }

    @Test
    public void maxSalariesViaCollector() throws Exception {
        Double res = Java8Utils.maxSalariesViaCollector(userList);
        assertEquals(5000, res, 0);
    }

}