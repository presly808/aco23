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
        return true;
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

    private static int[] addAndRet(int[] buff, int el) {
        int[] newArr = Arrays.copyOf(buff, buff.length + 1);
        newArr[newArr.length - 1] = el;
        return newArr;
    }

    // more complex solution based on above method
    public static Map<Integer, List<Integer>> allPossibleCombination(int[] income, int[] targets){
        return null;
    }

}
