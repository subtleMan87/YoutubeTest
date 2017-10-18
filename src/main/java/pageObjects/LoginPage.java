package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "identifierId")
    public WebElement loginField;

    @FindBy(xpath = "//span[text()='Далее']")
    public WebElement next;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passField;

    public LoginPage() {
        super();
    }

    public void login(String login, String pass) {
        visibilityOf(loginField, TIMEOUT);
        loginField.sendKeys(login);
        next.click();

        visibilityOf(passField, TIMEOUT);
        passField.sendKeys(pass);
        next.click();
    }
}

