package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        plugin = { "pretty", "html:target/reports/cucumber-report.html" }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
