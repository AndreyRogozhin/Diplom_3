package org.example;

import io.qameta.allure.Step;
import org.example.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestMainPage {

    private WebDriver driver;
    String mainPageUrl = Url.MAIN_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;


    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Вход по кнопке «Войти в аккаунт»")
    public void runTestClickEnterProfileLink()  {
// сначала надо создать клиента и авторизоваться
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());


        objMainPage.openMainPage(mainPageUrl);
        objMainPage.clickEnterProfileLink();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown(loginPageUrl));
    }


}
