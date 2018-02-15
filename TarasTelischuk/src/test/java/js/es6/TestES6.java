package js.es6;

import js.testtask1.TestJsSimple;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * Created by serhii on 11.02.18.
 */
public class TestES6 {

    @Test
    public void callFunctionCheck() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(
                TestES6.class.getResource("main.js").getFile()));

        String s = baos.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("My out " + s);
    }
}
