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


public class TestProfilePage {


    String token;
    Response response;
    LoginPage objLoginPage;
    MainPage objMainPage;
    UserClient userClient;
    org.example.apiobject.User user;
    org.example.apiobject.Credentials credentials;
    private WebDriver driver;

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
        credentials = user.credsFromUser();

        objLoginPage = new LoginPage(getWebDriver());
        objMainPage = new MainPage(getWebDriver());


        objLoginPage.openLoginPage(Url.LOGIN_PAGE);

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setEmail(user.getEmail());
        objLoginPage.setPassword(user.getPassword());
        objLoginPage.clickEnterButton();

        objMainPage.waitForLoadMainPage();


    }


    @Test
    @Step("Выход по кнопке «Выйти» в личном кабинете")
    public void runTestLogoutButton() {
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());
        objProfilePage.openProfilePage(Url.ACCOUNT_PAGE);
        objProfilePage.waitForLoadProfilePage();

        objProfilePage.clickLogoutButton();
        objLoginPage.waitForLoadLoginPage();


        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(Url.LOGIN_PAGE));
    }

    @Test
    @Step("Проверить переход по клику на «Конструктор» в личном кабинете")
    public void runTestConstructorLink() {
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());
        objProfilePage.openProfilePage(Url.ACCOUNT_PAGE);
        objProfilePage.waitForLoadProfilePage();

        objMainPage.clickConstructorLink();
        objMainPage.waitForLoadMainPage();

        Assert.assertTrue("Не открылась главная страница", objMainPage.checkMainPageShown(Url.MAIN_PAGE));
    }

    @Test
    @Step("Проверь переход в личном кабинете на логотип Stellar Burgers")
    public void runTestLogotypeLink() {
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());

        objProfilePage.openProfilePage(Url.ACCOUNT_PAGE);
        objProfilePage.waitForLoadProfilePage();


        objProfilePage.clickStellarBurgersLink();
        objMainPage.waitForLoadMainPage();

        Assert.assertTrue("Не открылась страница главная страница", objMainPage.checkMainPageShown(Url.MAIN_PAGE));
    }


    @After
    @Step("Удаление созданного клиента")
    public void tearDown() {
        response = userClient.delete(token);

        driver.quit();
    }


}
