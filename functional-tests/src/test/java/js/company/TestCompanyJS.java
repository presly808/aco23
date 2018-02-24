package js.company;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import javafx.beans.binding.ObjectExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 123456789
 */
public class TestCompanyJS {

    private ScriptEngine engine;
    private ByteArrayOutputStream baos;

    @Before
    public void before() throws FileNotFoundException, ScriptException {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(
                TestCompanyJS.class.getResource("main.js").getFile()));
        this.baos = getByteArrayOutputStreamFromSystemOut();
    }

    @After
    public void after() {
        this.engine = null;
    }


    @Ignore
    @Test
    public void addEmployeeFunction() throws FileNotFoundException, ScriptException, NoSuchMethodException {

        Invocable invocable = (Invocable) engine;

        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Ivan");
        emp.put("salary", "3000");

        Object res = invocable.invokeFunction("addEmployee", emp);

        Map<String,Object> employee = (Map<String, Object>) res;

        System.out.println(employee.containsKey("id"));
        String allPrintsInsideJs = baos.toString();

        restoreDefaultSystemOut();
        System.out.println("My out " + allPrintsInsideJs);
        System.out.println("My out " + res);
    }

    @Test
    public void testFunc() throws FileNotFoundException, ScriptException, NoSuchMethodException {

        Invocable invocable = (Invocable) engine;

        Function<Integer, Integer> function = new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer o) {
                return o + 1;
            }
        };

        Object res = invocable.invokeFunction("testFunction", function);
        Map<String,Object> employee = (Map<String, Object>) res;

        System.out.println(employee);
        String allPrintsInsideJs = baos.toString();

        restoreDefaultSystemOut();
        System.out.println("My out " + allPrintsInsideJs);
        System.out.println("My out " + res);
    }

    @Test
    public void testBiFunc() throws FileNotFoundException, ScriptException, NoSuchMethodException {

        Invocable invocable = (Invocable) engine;

        BiFunction<Integer,Integer, Integer> function = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        Object res = invocable.invokeFunction("testBiFunction", function);
        Map<String,Object> employee = (Map<String, Object>) res;

        System.out.println(employee);
        String allPrintsInsideJs = baos.toString();

        restoreDefaultSystemOut();
        System.out.println("My out " + allPrintsInsideJs);
        System.out.println("My out " + res);
    }

    private ByteArrayOutputStream getByteArrayOutputStreamFromSystemOut() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        return baos;
    }

    private void restoreDefaultSystemOut() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

}
