package java8.groupbyagg;

import java.util.Comparator;
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
        return list.stream().sorted(Comparator.comparing(User::getMoney).reversed()).limit(limit).
                collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list) {
        return list.stream().collect(groupingBy(User::getDepartment));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit) {
        return list.stream().collect(groupingBy(User::getDepartment, summingDouble(User::getMoney))).entrySet().
                stream().limit(limit).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list) {
        return list.stream().collect(groupingBy(user -> user.department.city));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list) {
        return list.stream().mapToDouble(User::getMoney).reduce((money1, money2) -> (money1 + money2)).getAsDouble();
    }

    public static Double maxSalariesViaCollector(List<User> list) {
        return list.stream().max(Comparator.comparing(User::getMoney)).get().money;
    }


}
