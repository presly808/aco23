package exclude;

import java.awt.*;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Test {
    public static void main(String[] args) {

        Stream.of(3,1,10, 4, 5,-2).sorted(Java8Test::comp).forEach(System.out::println);

    }

    public static void acc(int a){
        System.out.println(a);
    }

    public static int comp(int a, int b){
        return a - b;
    }

}
