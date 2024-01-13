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


    String profilePageUrl = Url.PROFILE_PAGE;
    String accountPageUrl = Url.ACCOUNT_PAGE;
    String mainPageUrl = Url.MAIN_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;
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

//    @Rule
//    public BrowserRule browserRule = new BrowserRule();

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
        token = response.path("accessToken");
        credentials = user.credsFromUser();
//        response = userClient.login(credentials );

        objLoginPage = new LoginPage(getWebDriver());
        objMainPage = new MainPage(getWebDriver());


        objLoginPage.openLoginPage(loginPageUrl);

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.setEmail(user.getEmail());
        objLoginPage.setPassword(user.getPassword());
        objLoginPage.clickEnterButton();

        objMainPage.waitForLoadMainPage();


    }


    @Test
    @Step("Выход по кнопке «Выйти» в личном кабинете")
    public void runTestLogoutButton() {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());
        objProfilePage.openProfilePage(accountPageUrl);
        objProfilePage.waitForLoadProfilePage();

        objProfilePage.clickLogoutButton();
        objLoginPage.waitForLoadLoginPage();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(loginPageUrl));
    }

    @Test
    @Step("Проверить переход по клику на «Конструктор» в личном кабинете")
    public void runTestConstructorLink() {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());
        //        MainPage objMainPage = new MainPage(getWebDriver());
//        objMainPage.openMainPage(mainPageUrl);
        objProfilePage.openProfilePage(accountPageUrl);
        objProfilePage.waitForLoadProfilePage();

        objMainPage.clickConstructorLink();
        objMainPage.waitForLoadMainPage();

        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась главная страница", objMainPage.checkMainPageShown(mainPageUrl));
    }

    @Test
    @Step("Проверь переход в личном кабинете на логотип Stellar Burgers")
    public void runTestLogotypeLink() {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(getWebDriver());

        objProfilePage.openProfilePage(accountPageUrl);
        objProfilePage.waitForLoadProfilePage();


        objProfilePage.clickStellarBurgersLink();
        objMainPage.waitForLoadMainPage();

        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница главная страница", objMainPage.checkMainPageShown(mainPageUrl));
    }


    @After
    @Step("Удаление созданного клиента")
    public void tearDown() {
        response = userClient.delete(token);

        driver.quit();
    }


}
