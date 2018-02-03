package company.utils.reflection;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ReflectionUtilsTest {

    @Test
    public void getMethodName() {
        String name = ReflectionUtils.getMethodName(0);
        assertThat(name, CoreMatchers.containsString("getMethodName"));
    }

    @Test
    public void getNoSuchLevel() {
        String name = ReflectionUtils.getMethodName(Integer.MAX_VALUE);
        assertThat(name, CoreMatchers.equalTo("no such level"));
    }
}