package week4.recursion;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRecTest {
    @Test
    public void canFindSum() throws Exception {
        boolean res = BacktrackingRec.canFindSum(new int[]{1,5,10,20,9,7},34);
        Assert.assertTrue(res);
    }

    @Test
    public void canFindSumNeg() throws Exception {
        boolean res = BacktrackingRec.canFindSum(new int[]{1,5,10,20,9,7},23);
        Assert.assertFalse(res);
    }

    @Test
    public void findChainIfPossible() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},34);
        Assert.assertArrayEquals(new int[]{5,20,9},res);

    }

    @Test
    public void findChainIfPossibleNeg() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},115);
        Assert.assertArrayEquals(new int[]{},res);

    }
    @Test
    public void findChainIfPossibleNeg2() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1,5,10,20,9,7},4);
        Assert.assertArrayEquals(new int[]{},res);

    }


    @Test
    public void allPossibleCombination() throws Exception {
        Map<Integer, List<Integer>> integerListMap =
                BacktrackingRec.allPossibleCombination(new int[]{1, 5, 10, 20, 9, 7}, new int[]{4, 21, 20});
        Assert.assertEquals(integerListMap.get(4),new ArrayList<>());
        Assert.assertEquals(integerListMap.get(20), Stream.of(20).collect(Collectors.toList()));


    }

}