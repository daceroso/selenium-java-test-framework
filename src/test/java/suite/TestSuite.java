package suite;

import com.test.framework.pom.tests.MainPageTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("com.test.framework.pom.tests")
@SelectClasses(MainPageTest.class)
public class TestSuite {
}
