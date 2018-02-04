package week4.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        int [] mas1 = Arrays.copyOfRange(mas, 0, mas.length);
        return canFindSum(mas1, target - mas[0]) || canFindSum(mas1, target);

    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target){
        return null;
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){
        return null;
    }

}
