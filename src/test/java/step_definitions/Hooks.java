package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {

    // - Before and After all scenarios. - @BeforeAll and @AfterAll (the methods should be static)
    // - Before and After each scenario. - @Before and After (the methods should be instance)
    // - Before and After each step. - @BeforeStep and AfterStep (the methods should be instance)

    // We will use the Before and After Scenario
    @Before
    public void setUp() {
        // Apply implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Maximize the window
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/jpeg","screenshot");
        }
        Driver.quitDriver();
    }
}
