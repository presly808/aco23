package company.utils;

import org.junit.*;
import java.util.*;

public class MyUtilsTest {
    @Test
    public void genId() {
        Set<Integer> uniqueIds = new HashSet<>();

        int count = 10_000;
        for (int i = 0; i < count; i++) uniqueIds.add(MyUtils.genId());

        Assert.assertEquals(uniqueIds.size(), count);
    }
}
