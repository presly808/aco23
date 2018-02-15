package java8.groupbyagg;



import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toList;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                sorted(Comparator.comparing(User::getMoney).reversed()).
                limit(limit).
                collect(toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                collect(groupingBy(User::getDepartment, toList()));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                filter(user -> user.getDepartment().getId() <= limit).
                collect(groupingBy(User::getDepartment, summingDouble(User::getMoney)));

    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                collect(groupingBy(user -> user.getDepartment().getCity(), toList()));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                mapToDouble(User::getMoney).
                reduce(0, Double::sum);

//        Or:
//        return res.stream().
//                mapToDouble(User::getMoney).
//                sum();

    }

    public static Double maxSalariesViaCollector(List<User> list){
        List<User> res = new ArrayList<>(list);

        return res.stream().
                mapToDouble(User::getMoney).
                max().
                getAsDouble();
    }


}
