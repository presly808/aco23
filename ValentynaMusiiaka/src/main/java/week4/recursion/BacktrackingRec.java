package week4.recursion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target){
        //        condition to exit recursion
        if(mas.length == 0) return target == 0;
        if(target == 0) return true;


        int targetDecreased = target - mas[0];
        mas = Arrays.copyOfRange(mas, 1, mas.length);

        boolean branch1 = canFindSum(mas, targetDecreased);
        boolean branch2 = canFindSum(mas, target);

        return branch1 || branch2;
    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){
        return findChainIfPossible(mas, new int[0], target);
    }

    private static int[] findChainIfPossible(int[] mas, int[] buff, int target){
        if(mas.length == 0){
            return target == 0 ? buff : new int[]{};
        }

        int[] arr = Arrays.copyOfRange(mas, 1, mas.length);

        int[] a1 = findChainIfPossible(arr, buff, target);
        int[] a2 = findChainIfPossible(arr, addAndRet(buff, mas[0]), target - mas[0]);

        return a1.length != 0 ? a1 : a2;
    }

    private static int[] addAndRet(int[] buff, int num) {
        int[] newBuff = Arrays.copyOf(buff, buff.length + 1);
        newBuff[newBuff.length - 1] = num;
        return newBuff;
    }


    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){

        Map<Integer, List<Integer>> res = new HashMap<>();
        List<Integer> addsList;
        int adds[];

        for (int i = 0; i < targets.length; i++) {
            adds = findChainIfPossible(income, targets[i]);
            addsList = Arrays.stream(adds).boxed().collect(Collectors.toList());
            res.put(targets[i], addsList);
        }

        return res;
    }


}
