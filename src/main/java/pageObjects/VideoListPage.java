package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VideoListPage extends BasePage {

    @FindBy(xpath = "//li[@data-ng-repeat='videoItem in ctrl.videoItems']")
    public List<WebElement> videoList;

    @FindBy(xpath = "//li[@data-ng-repeat='videoItem in ctrl.videoItems']")
    public WebElement firstVideo;

    @FindBy(xpath = "(//div[@class='yt-uix-menu vm-video-action-button-selected']//span[text()='Действия'])[2]")
    public WebElement actions;

    @FindBy(xpath = "(//button[@bulk-action='tags'])[2]")
    public WebElement tagsMenu;

    @FindBy(xpath = "//input[@aria-label='Укажите теги']")
    public WebElement tagsField;

    @FindBy(xpath = "//span[text()='Отправить']")
    public WebElement sendBtn;

    @FindBy(xpath = "//span[text()='Я понимаю, что это действие нельзя будет отменить.']")
    public WebElement notification;

    @FindBy(xpath = "//span[text()='Да, внести']")
    public WebElement acceptNotification;

    public void addTags(String tags) {
        switchToNewWnd();

        visibilityOf(firstVideo,TIMEOUT);
        wait(2);

        WebElement firstVideo = videoList.get(0);
        firstVideo.findElement(By.xpath("//input[@type='checkbox' and @name='video-checkbox']")).click();

        actions.click();
        tagsMenu.click();

        tagsField.sendKeys(tags);
        sendBtn.click();

        notification.click();
        acceptNotification.click();

        videoList.get(0).findElement(By.xpath("//input[@type='checkbox' and @name='video-checkbox']")).click();
        videoList.get(0).findElement(By.xpath("//span[text()='Опубликовать']")).click();
    }

}

