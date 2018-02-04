package week4.recursion;

import java.util.List;
import java.util.Map;
import java.util.Arrays;

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

//    public static boolean groupSum(int start, int[] nums, int target) {
//
//        if(start == nums.length){
//            return target == 0;
//        }
//
//        if(target == 0){
//            return true;
//        }
//
//        boolean branch1 = groupSum(start + 1, nums, target - nums[start]);
//
//        boolean branch2 = groupSum(start + 1, nums, target);
//
//        return branch1 || branch2;
//
//    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){
        return null;
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){
        return null;
    }

}
