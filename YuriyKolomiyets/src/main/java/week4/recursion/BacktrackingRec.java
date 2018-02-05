package week4.recursion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.copyOfRange;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target){

       if (mas.length == 0){
           return target == 0;
       } else if (target == 0){
           return true;
       }

        boolean branch1 = canFindSum(copyOfRange(mas, 1, mas.length), target - mas[0]);
        boolean branch2 = canFindSum(copyOfRange(mas, 1, mas.length), target);

        return branch1 || branch2;

        /*
        boolean branch1 = canFindSum(Arrays.copyOfRange(mas, 0, mas.length-1), target - mas[mas.length-1]);
        boolean branch2 = canFindSum(Arrays.copyOfRange(mas, 0, mas.length-1), target);
        return branch1 || branch2;
         */
        }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){

        return findChainIfPossible(mas,new int[0], target);

    }

    private static int[] findChainIfPossible(int[] mas, int[] buff, int target){

        if (mas.length == 0){
            return target == 0 ? buff : new int[]{};
        }

        addAndRet(buff, mas[0]);

        int[] arr = copyOfRange(mas, 1, mas.length);

        int[] a1 = findChainIfPossible(arr, buff, target);
        int[] a2 = findChainIfPossible(arr, addAndRet(buff, mas[0]),target - mas[0]);

        if (a1.length != 0) return a1;
        else return a2;
    }

    private static int[] addAndRet(int[] buff, int ma) {
        int[] newArr = Arrays.copyOf(buff, buff.length+1);
        newArr[newArr.length-1] = ma;
        return newArr;
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){

    Map<Integer, List<Integer>> ret = new HashMap<>();

          for (int target : targets) {
        ret.put(target, IntStream.of(findChainIfPossible(income, target)).boxed().collect(Collectors.toList()));
    }
         return ret;
}
}
