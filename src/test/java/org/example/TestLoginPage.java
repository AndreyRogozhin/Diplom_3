package org.example;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.example.apiobject.UserClient;
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
//import org.openqa.selenium.remote.Response;

public class TestLoginPage {

    private WebDriver driver;

    public WebDriver getWebDriver() {
        return driver;
    }


    String mainPageUrl = Url.MAIN_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;
    String token;
    private Response response;
    private UserClient userClient;
    private org.example.apiobject.User user;
    private org.example.apiobject.Credentials credentials, cred2;


    //@Rule
    //public BrowserRule browserRule = new BrowserRule();

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//        new WebDriverWait(driver, 3)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text() = 'Получить ссылку на маршрут']")));


        RestAssured.baseURI = Url.MAIN_PAGE;

        user = randomUser();
        userClient = new UserClient();
        response = userClient.create(user);
    //    credentials = user.credsFromUser();
//        cred2 = response.body().as(org.example.Credentials.class);
        token = response.path("accessToken");


    }

    @Test
    @Step("Авторизация с email и паролем созданного пользователя")
    public void runTestLoginPageOK() throws InterruptedException {

        MainPage objMainPage = new MainPage(getWebDriver());
        LoginPage objLoginPage = new LoginPage(getWebDriver());
        objLoginPage.openLoginPage(loginPageUrl);

//        objLoginPage.setEmail(credentials.getEmail());
//        objLoginPage.setPassword(credentials.getPassword());

        objLoginPage.setEmail(user.getEmail());
        objLoginPage.setPassword(user.getPassword());

        objLoginPage.clickEnterButton();


        //objRecoverPasswordPage.clickLoginLink();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Thread.sleep(500,0);
        Assert.assertTrue("Не открылась главная страница сайта",objMainPage.checkMainPageShown (mainPageUrl));
    }
    @After
    @Step("Удаление созданного клиента")
    public void tearDown() {
        response = userClient.delete(token);

        driver.quit();
    }



}
