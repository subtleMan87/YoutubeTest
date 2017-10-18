package steps_definition;

/**
 * Created by Ser on 15.12.2015.
 */

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BasePage;

import java.io.File;

public class SetupSteps {

    @Before
    public void init() {
        BasePage.initDriver();
    }

    @After
    public void close() {
        BasePage.closeDriver();
    }
}
