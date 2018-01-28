package company.utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MyUtilsTest {

    @Test
    public void genId() {
        int count = 100;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = MyUtils.genId();
        }
        boolean isUnic = true;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] == arr[j]) {
                    isUnic = false;
                    break;
                }
            }
        }
        assertTrue(isUnic);
    }
}