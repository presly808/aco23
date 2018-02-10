package exclude.testwebpage;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class TestWeb {

    @Before
    public void prepare() {
        setBaseUrl("http://localhost:8080/test");
    }

    @Test
    public void testLogin() {
        beginAt("/home");
        clickLink("login");
        assertTitleEquals("Login");
        setTextField("username", "test");
        setTextField("password", "test123");
        submit();
        assertTitleEquals("Welcome, test!");
    }
}

