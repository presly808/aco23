package week4.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target){
        if(mas.length == 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        int [] arr = Arrays.copyOfRange(mas, 1, mas.length);
        return canFindSum(arr, target - mas[0]) || canFindSum(arr, target);

    }
//------------------------------------------------------------------------------------------

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target) {
        return findChainIfPossible(mas, new int[0], target);
    }

    private static int[] findChainIfPossible(int[] mas, int[] buf, int target){
        if(mas.length == 0){
            return target == 0 ? buf : new int[]{};
        }
        addAndRet(buf, mas[0]);
        int[] arr = Arrays.copyOfRange(mas, 1, mas.length);
        int[] a1 = findChainIfPossible(arr, buf, target);
        int[] a2 = findChainIfPossible(arr, addAndRet(buf, mas[0]), target - mas[0]);

        return a1.length != 0 ? a1 : a2;
    }

    private static int[] addAndRet(int[] buf, int el) {
            int[] newArr = Arrays.copyOf(buf, buf.length + 1);
            newArr[newArr.length - 1] = el;
            return newArr;
    }
//-------------------------------------------------------------------------------------------------

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int target: targets){
            map.put(target, IntStream.of(findChainIfPossible(income, target)).boxed().collect(Collectors.toList()));
        }
        return map;
    }

}
