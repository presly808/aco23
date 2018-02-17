/*
package js.testtask1;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

*/
/**
 * Created by serhii on 10.02.18.
 *//*

public class TestJsSimple {

    @Test
    public void testCheck() throws FileNotFoundException, ScriptException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
//        Object res = scriptEngine.eval(new FileReader(TestJsSimple.class.getResource("task1.js").getFile()));
        Object res = scriptEngine.eval(
                new FileReader(
                        TestJsSimple.class.getResource("test.js").getFile()));


        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("My out " + s);
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
}
*/
