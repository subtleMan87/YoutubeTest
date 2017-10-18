package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    private static String URL = "https://www.youtube.com";
    private static int numberOfTry = 200;

    @FindBy(xpath = "//yt-formatted-string[@id='text' and text()='Войти']")
    public WebElement entry;

    @FindBy(id = "search")
    public WebElement search;

    @FindBy(xpath = "(//form[@id='search-form']//button[@aria-label='Введите запрос'])[2]")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='contents']//ytd-video-renderer")
    public List<WebElement> videos;

    public MainPage() {
        super();
    }

    public void open() {
        getDriver().get(URL);
        visibilityOf(search, TIMEOUT);
    }

    public void goToLogin() {
        entry.click();
    }

    public void searchVideoByTimeout(String duration, String name,String author) {
        getDriver().get(URL);
        visibilityOf(search, TIMEOUT);

        search.sendKeys("VoicesWindows");
        boolean isFind=false;
        //Сервис довольно долго выкладывает видео
        for (int i = 0; i < numberOfTry; i++) {
            isFind = searchVideo(duration, name, author);
            if (isFind) {
                break;
            }
            wait(5);
        }

        Assert.assertTrue("Загруженная запись не обнаружена за 20 попыток", isFind);
    }

    public boolean searchVideo(String duration, String name,String author) {

        searchBtn.click();
        //TODO Подождем результатов работы. На будущее добавить более адекватную проверку
        wait(3);

        //Пройдемся по найденным видео и будем искать наш по имени файла и ФИ пользователя
        boolean isFind=false;
        String[] attributes;
        for (WebElement video : videos) {
            attributes = video.getText().split("\\n");

            if (attributes[0].equals(duration)
                    && attributes[1].equals(name)
                    && attributes[2].equals(author)
                    ) {
                isFind = true;
                break;
            }
        }
        return isFind;
    }

}

