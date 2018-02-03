package week4.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target) {
        if (mas.length == 0) {
            return false;
        }
        if (target < 0) {
            return false;
        }

        int[] buf = Arrays.copyOfRange(mas, 1, mas.length);

        return target == 0 || canFindSum(buf, target - mas[0]) || canFindSum(buf, target);
    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){
        if (!canFindSum(mas, target))
            return new int[0];

        if (target == mas[0])
            return new int[] {target};

        int[] buf = Arrays.copyOfRange(mas, 1, mas.length);

        if (canFindSum(buf, target - mas[0]))
            return mergeArr(new int[]{mas[0]}, findChainIfPossible(buf, target - mas[0]));
        if (canFindSum(buf, target))
            return findChainIfPossible(buf, target);

        return new int[0];
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int target : targets) {
            map.put(target, IntStream.of(findChainIfPossible(income, target)).boxed().collect(Collectors.toList()));
        }
        return map;
    }

    private static int[] mergeArr(int[] arr1, int[] arr2) {
        int[] resultArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, resultArr, 0, arr1.length);
        System.arraycopy(arr2, 0, resultArr, arr1.length, arr2.length);
        return resultArr;
    }

}
