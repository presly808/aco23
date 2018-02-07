package java8.groupbyagg;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return list.stream().sorted((u1,u2) -> Double.compare(u2.money,u1.money)).
                limit(limit).collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return list.stream().collect(Collectors.groupingBy(user->user.department));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        return list.stream().collect(groupingBy(user -> user.department,
                Collectors.summingDouble(user->user.money))).entrySet().stream().
                limit(limit).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return list.stream().collect(groupingBy(user -> user.department.city));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return list.stream().mapToDouble(user -> user.money).
                reduce((money, money2) -> money+money2).getAsDouble();
    }

    public static Double maxSalariesViaCollector(List<User> list){
        return list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(user -> user.money))).get().money;
    }


}
