package seleniumTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("xyz.howtoprogram.junit5.aco23")
@SelectClasses({LoginTests.class})
public class TestRunner extends Fixture {

}
