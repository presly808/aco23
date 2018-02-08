package week4.recursion;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRecTest {
    @Test
    public void canFindSum() throws Exception {
        boolean res = BacktrackingRec.canFindSum(new int[]{1, 5, 10, 20, 9, 7}, 34);
        assertTrue(res);
    }

    @Test
    public void canFindSumNeg() throws Exception {
        boolean res = BacktrackingRec.canFindSum(new int[]{1, 5, 10, 20, 9, 7}, 120);
        assertFalse(res);
    }

    @Test
    public void findChainIfPossible() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1, 5, 10, 20, 9, 7}, 34);
        assertArrayEquals(new int[]{5, 20, 9}, res);

    }

    @Test
    public void findChainIfPossibleNeg() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1, 5, 10, 20, 9, 7}, 115);
        assertArrayEquals(new int[]{}, res);

    }

    @Test
    public void findChainIfPossibleNeg2() throws Exception {
        int[] res = BacktrackingRec.findChainIfPossible(new int[]{1, 5, 10, 20, 9, 7}, 4);
        assertArrayEquals(new int[]{}, res);

    }


    @Test
    public void allPossibleCombination() throws Exception {
        Map<Integer, List<Integer>> integerListMap =
                BacktrackingRec.allPossibleCombination(new int[]{1, 5, 10, 20, 9, 7}, new int[]{4, 21, 20});
        assertEquals(integerListMap.get(4), new ArrayList<>());
//        assertEquals(integerListMap.get(21), Stream.of(1, 20).collect(Collectors.toList()));
        assertThat(integerListMap.get(21),
                anyOf(
                        equalTo(Arrays.asList(1, 20)),
                        equalTo(Arrays.asList(5, 9, 7))
                )
        );
        assertEquals(integerListMap.get(20), Stream.of(20).collect(Collectors.toList()));


    }

}