package week4.recursion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target){
        if (mas.length == 0 || target < 0){
            return false;
        }
        int[] mas2 = Arrays.copyOfRange(mas, 1, mas.length);

        boolean branch1 = canFindSum(mas2, target - mas[0]);
        boolean branch2 = canFindSum(mas2 ,target);

        return target == 0 || branch1 || branch2;
    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){
        return findChainIfPossible(mas, new int[0], target);
        }


    private static int[] findChainIfPossible(int[] mas, int[] buff, int target){
        if(mas.length == 0){
            return target == 0 ? buff : new int[]{};
        }
        int[] arr = Arrays.copyOfRange(mas,1,mas.length);
        int[] a1 = findChainIfPossible(arr,buff,target);
        int[] a2 = findChainIfPossible(arr,addAndRet(buff,mas[0]),target - mas[0]);

        return a1.length != 0 ? a1 : a2;
    }

    private static int[] addAndRet(int[] buff, int ma) {
        int[] newArr = Arrays.copyOf(buff, buff.length + 1);
        newArr[newArr.length - 1] = ma;
        return newArr;
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int target : targets) {
            map.put(target, IntStream.of(findChainIfPossible(income, target)).boxed().collect(Collectors.toList()));
        }
        return map;
    }

}
