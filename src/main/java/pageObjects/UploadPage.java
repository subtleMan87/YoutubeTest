package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;


public class UploadPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Добавить видео']")
    public WebElement addVideo;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement upload;

    @FindBy(xpath = "//div[@class='upload-failure hid' and text()='Загрузка завершена.']")
    public WebElement uploadIsSuccess;

    @FindBy(xpath = "//span[text()='Менеджер видео']")
    public WebElement managerBtnVideo;

    public UploadPage() {
        super();
    }

    public void upload(String fileName) {
        File file = new File("src/test/resources/video/" + fileName);

        visibilityOf(addVideo, TIMEOUT);
        addVideo.click();

        upload.sendKeys(file.getAbsolutePath());

        //Далее ждем пока текст не появится, что загрузка заверщена
        visibilityOf(uploadIsSuccess, TIMEOUT);
        managerBtnVideo.click();
        //TODO Подождем публикацию, на будущее более адекватную проверку
        wait(5);
    }
}

