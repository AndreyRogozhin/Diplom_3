package org.example;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.apiobject.UserClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.example.apiobject.UserGenerator.randomUser;

public class TestLoginPage {

    String token;
    private WebDriver driver;
    private Response response;
    private UserClient userClient;
    private org.example.apiobject.User user;

    public WebDriver getWebDriver() {
        return driver;
    }


    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));


        RestAssured.baseURI = Url.MAIN_PAGE;

        user = randomUser();
        userClient = new UserClient();
        response = userClient.create(user);
        token = response.path("accessToken");


    }

    @Test
    @Step("Авторизация с email и паролем созданного пользователя")
    public void runTestLoginPageOK() throws InterruptedException {

        MainPage objMainPage = new MainPage(getWebDriver());
        LoginPage objLoginPage = new LoginPage(getWebDriver());
        objLoginPage.openLoginPage(Url.LOGIN_PAGE);

        objLoginPage.setEmail(user.getEmail());
        objLoginPage.setPassword(user.getPassword());
        objLoginPage.clickEnterButton();


        Thread.sleep(500, 0);
        Assert.assertTrue("Не открылась главная страница сайта", objMainPage.checkMainPageShown(Url.MAIN_PAGE));
    }

    @After
    @Step("Удаление созданного клиента")
    public void tearDown() {
        response = userClient.delete(token);

        driver.quit();
    }


}
