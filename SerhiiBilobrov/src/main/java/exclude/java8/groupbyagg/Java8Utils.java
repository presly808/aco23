package exclude.java8.groupbyagg;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return null;
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return null;
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit) throws Exception {

        Map<Department, Double> collect = list.stream().collect(
                groupingBy(el -> el.department, Collectors.summingDouble(User::getMoney)));


        /*BinaryOperator<User> binaryOperator = new BinaryOperator<User>() {
            @Override
            public User apply(User user, User user2) {
                return user.getMoney() > user2.getMoney() ? user : user2;
            }
        };



        Optional<User> optional = list.stream().reduce(binaryOperator);

        return null;*/
        return null;
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries2(List<User> list, int limit){

        return list.stream().filter(user -> user.department.id <= limit).
                collect(groupingBy(user -> user.department, summingDouble(User::getMoney)));

    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return null;
    }

    public static Double maxSalariesViaCollector(List<User> list){
        return null;
    }


}
