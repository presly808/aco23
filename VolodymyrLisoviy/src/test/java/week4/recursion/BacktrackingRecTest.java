package week4.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRecTest {
    @Test
    public void canFindSum() {
        boolean res = BacktrackingRec.canFindSum(new int[]{1,5,10,20,9,7},34);
        Assert.assertTrue(res);
    }

    @Test
    public void findChainIfPossible() {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},34);
        Assert.assertArrayEquals(new int[]{5,20,9},res);
    }

    @Test
    public void findChainIfPossibleNeg() {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},115);
        Assert.assertArrayEquals(new int[]{},res);
    }
    @Test
    public void findChainIfPossibleNeg2() {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},4);
        Assert.assertArrayEquals(new int[]{},res);
    }


    @Test
    public void allPossibleCombination() {
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(34, Arrays.asList(5, 20, 9));
        expected.put(15, Arrays.asList(1, 5, 9));
        expected.put(4, new ArrayList<>());
        expected.put(-20, new ArrayList<>());
        Map<Integer, List<Integer>> actual = BacktrackingRec.allPossibleCombination(new int[]{1, 5, 10, 20, 9, 7}, new int[] {34, 15, 4, -20});
        actual.forEach((key, value) -> Assert.assertEquals(expected.get(key), actual.get(key)));
    }

}