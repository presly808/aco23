package js.testtask1;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * Created by serhii on 10.02.18.
 */
public class TestJsSimple {


    @Test
    public void testCheck() throws FileNotFoundException, ScriptException {

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
//        Object res = scriptEngine.eval(new FileReader(TestJsSimple.class.getResource("task1.js").getFile()));
        Object res = scriptEngine.eval(
                new FileReader("/home/serhii/dev/projects/aco23/functional-tests/src/main/java/js/testtask1/task1.js"));

    }
}