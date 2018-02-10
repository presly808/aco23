package js.testtask1;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by serhii on 10.02.18.
 */
public class TestJsSimple {


    @Test
    public void testCheck() throws FileNotFoundException, ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        Object res = scriptEngine.eval(new FileReader(TestJsSimple.class.getResource("task1.js").getFile()));
        System.out.println(res);
    }
}
