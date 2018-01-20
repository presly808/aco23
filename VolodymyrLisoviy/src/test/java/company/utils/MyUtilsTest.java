package company.utils;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MyUtilsTest {

    @Test
    public void genId() {
        Set<Integer> idSet = new HashSet<>();

        int count = 1000;
        for (int i = 0; i < count; i++)
            idSet.add(MyUtils.genId());

        assertEquals(count, idSet.size());
    }
}