package exclude;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by serhii on 28.01.18.
 */
public class Main {

    public static void main(String[] args) {
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
//        Foo foo = new FooImpl();
        foo.bar(null);
        foo.test1();

    }
}

interface Foo {
    Object bar(Object obj);

    void test1();
}

class FooImpl implements Foo {
    public Object bar(Object obj){
       return "Test";
    }

    @Override
    public void test1() {
        System.out.println("test");
    }
}

class DebugProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new DebugProxy(obj));
    }

    private DebugProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable {
        Object result;
        try {
            System.out.println("before method " + m.getName());
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
            System.out.println("after method " + m.getName());
        }
        return result;
    }
}
