package company.controller;

import company.utils.MyUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UtilTest {

    @Test
    public void testUtilRandomMethod() {
        assertThat(MyUtils.genId(), CoreMatchers.not(MyUtils.genId()));
    }
}
