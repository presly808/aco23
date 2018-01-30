package company.utils.reflection;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectionTest {
    @Test
    public void getMethodName(){
        String name = Reflection.getMethodName(0);
        assertThat(name, CoreMatchers.containsString("getMethodName"));
    }


}