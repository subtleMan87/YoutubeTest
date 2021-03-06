package pageObjects;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Set;

/**
 * Created by admin on 17.10.2017.
 */
public class BasePage extends PageFactory {

    private static WebDriver driver;
    private static String path = "src/test/resources/drivers/";
    public final static int TIMEOUT=30;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public static void initDriver() {
        if (driver == null) {
            File chromeDriverFile = new File(path + "chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    public void visibilityOf(WebElement element, int seconds) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }

    public void switchToNewWnd() {
        // Switch to new window opened
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }


}
