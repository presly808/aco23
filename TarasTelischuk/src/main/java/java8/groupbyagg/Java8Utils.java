package java8.groupbyagg;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toMap;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit) {
        return list.stream().sorted(Comparator.comparingDouble(User::getMoney).reversed()).limit(limit).collect(Collectors.toList());
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
        return list.stream().mapToDouble(value -> value.money).sum();
        //return list.stream().mapToDouble(value -> value.money).reduce((money1, money2)-> money1 + money2).getAsDouble();
    }

    public static Double maxSalariesViaCollector(List<User> list){
        return list.stream().max(Comparator.comparing(User::getMoney)).get().money;
    }


}
