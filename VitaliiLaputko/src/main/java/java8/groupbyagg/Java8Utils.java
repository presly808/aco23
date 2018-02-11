package java8.groupbyagg;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return list.stream().sorted(Comparator.comparingDouble(Object::hashCode)
                .reversed()).limit(limit).collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return list.stream().collect(groupingBy(user -> user.department));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        return list.stream().filter(user -> user.department.id <= limit)
                .collect(groupingBy(user -> user.department, summingDouble(User::getMoney)));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return list.stream().collect(groupingBy(user -> user.department.city));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return list.stream().mapToDouble(user -> user.money)
                .reduce(0, (x,y) -> x+y);
    }

    public static Double maxSalariesViaCollector(List<User> list) {
        return list.stream().max(Comparator.comparingDouble(u -> u.money))
                .get().money;
    }
}
