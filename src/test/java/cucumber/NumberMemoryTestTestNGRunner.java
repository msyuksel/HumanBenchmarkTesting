package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features = "src/test/java/cucumber",
		glue = "stepDefinitions",
		monochrome = true, tags = "@Regression", plugin =
		"html:target/cucumber.html" )


public class NumberMemoryTestTestNGRunner extends AbstractTestNGCucumberTests {
}
