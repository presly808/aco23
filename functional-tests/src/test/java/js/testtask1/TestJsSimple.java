package js.testtask1;

import jdk.nashorn.api.scripting.JSObject;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by serhii on 10.02.18.
 */
public class TestJsSimple {

    @Test
    public void testCheck() throws FileNotFoundException, ScriptException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(
                new FileReader(
                        TestJsSimple.class.getResource("test.js").getFile()));


        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        Assert.assertThat(s, CoreMatchers.is("Andrey"));
    }

    @Test
    public void callFunctionCheck() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(
                TestJsSimple.class.getResource("task1.js").getFile()));

        Invocable invocable = (Invocable) scriptEngine;
        Object res1 = invocable.invokeFunction("sum",2, 3);

        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("My out " + s);
        System.out.println("My out " + res1);
    }

    @Test
    public void testFunc() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(
                TestJsSimple.class.getResource("task1.js").getFile()));

        Invocable invocable = (Invocable) scriptEngine;

        Function<Integer, Integer> function = o -> o + 1;

        Object resFun = invocable.invokeFunction("testFunction",function,1);
        Assert.assertThat(resFun, CoreMatchers.is(2));

    }

    @Test
    public void testBiFunc() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        scriptEngine.eval(new FileReader(
                TestJsSimple.class.getResource("task1.js").getFile()));

        Invocable invocable = (Invocable) scriptEngine;

        BiFunction<Integer,Integer, Integer> function = (integer, integer2) -> integer + integer2;

        Object res = invocable.invokeFunction("testBiFunction", function,2,3);
        Assert.assertThat(res, CoreMatchers.is(5));
    }

    @Test
    public void callFunctionWithErrorCheck() throws FileNotFoundException, ScriptException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(
                TestJsSimple.class.getResource("task1.js").getFile()));

        Invocable invocable = (Invocable) scriptEngine;
        Object res1 = null;
        try {
            res1 = invocable.invokeFunction("errorTest");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("My out " + s);
        System.out.println("My out " + res1);
    }

    @Test
    public void callFunctionOopCheck() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(
                TestJsSimple.class.getResource("oop.js").getFile()));

        JSObject pointFunc = (JSObject)scriptEngine.get("User");
        JSObject pointObj =  (JSObject)pointFunc.newObject("Ivan", 55);

        Invocable invocable = (Invocable) scriptEngine;
        Object res3 = invocable.invokeMethod(pointObj,"hello");

        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("My out " + s);
        System.out.println("My out " + s);
        System.out.println(res3);

    }


}
