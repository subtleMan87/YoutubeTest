package steps_definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.*;


public class StepDefs {

    @When("^Логинимся в сервис YouTube с логином (.*) и паролем (.*)$")
    public void auth(String login, String pass) throws Throwable {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.goToLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.login(login, pass);
    }

    @Then("^Загружаем видео (.*)$")
    public void uploadVideo(String name) throws Throwable {
        UploadPage uploadPage = new UploadPage();
        uploadPage.upload(name);
    }

    @Then("Добавляем теги (.*) и публикуем$")
    public void addTagsAndPublish(String tags) throws Throwable {
        VideoListPage videoListPage = new VideoListPage();
        videoListPage.addTags(tags);
    }

    @Then("Ищем загруженное видео с длительностью (.*) названием (.*) и автором (.*)$")
    public void searchVideo(String duration, String name,String author) throws Throwable {
        MainPage mainPage = new MainPage();
        mainPage.searchVideoByTimeout(duration, name, author);
    }
}