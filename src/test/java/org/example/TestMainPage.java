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
    public void runTestClickEnterAccountLink()  {
// это для неавторизованного пользователя, но он должен быть создан

        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());


        objMainPage.openMainPage(mainPageUrl);
        objMainPage.clickEnterAccountButton();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown(loginPageUrl));
    }


    @Test
    @Step("Вход по кнопке «Войти в личный кабинет»")
    public void runTestClickProfileLink()  {
// это для неавторизованного пользователя, но он должен быть создан

        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());


        objMainPage.openMainPage(mainPageUrl);
        objMainPage.clickEnterProfileLink();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown(loginPageUrl));
    }





    @Test
    @Step("Переход на закладку Булки")
    public void runTestClickBunTab() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(mainPageUrl);

        objMainPage.clickDivisionFillingTab();
        objMainPage.clickDivisionBunTab();

        Assert.assertTrue("Не получился переход на булки", objMainPage.tabBunIsCurrent());
    }

    @Test
    @Step("Переход на закладку Соусы")
    public void runTestClickSauceTab() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(mainPageUrl);
        objMainPage.clickDivisionSauceTab();

        Assert.assertTrue("Не получился переход на соусы", objMainPage.tabSauceIsCurrent());
    }

    @Test
    @Step("Переход на закладку Начинки")
    public void runTestClickFillingTab() throws InterruptedException {
// сначала надо создать клиента и авторизоваться
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(mainPageUrl);
        objMainPage.clickDivisionFillingTab();

        Assert.assertTrue("Не получился переход на начинки", objMainPage.tabFillingIsCurrent());
    }

    public void tearDown() {
        driver.quit();
    }


}
