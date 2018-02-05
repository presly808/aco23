package java8.groupbyagg;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return list.stream().sorted(Comparator.comparing(User::getMoney).reversed()).
                    limit(limit).collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){

       return list.stream().collect(Collectors.groupingBy(User::getDepartment));

    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        return null;
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return null;
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return null;
    }

    public static Double maxSalariesViaCollector(List<User> list){
        return null;
    }


}
