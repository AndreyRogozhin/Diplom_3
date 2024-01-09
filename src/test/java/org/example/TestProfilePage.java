package org.example;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestProfilePage {


    private WebDriver driver;
    String profilePageUrl = Url.ACCOUNT_PAGE;
    String mainPageUrl = Url.MAIN_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;


    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Выход по кнопке «Выйти» в личном кабинете")
    public void runTestLogoutButton()  {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objProfilePage.openProfilePage(profilePageUrl);

        objProfilePage.clickLogoutButton();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown (loginPageUrl));
    }

    @Test
    @Step("Проверь переход по клику на «Конструктор» в личном кабинете и на логотип Stellar Burgers")
    public void runTestConstructorLink()  {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(browserRule.getWebDriver());
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        objProfilePage.openProfilePage(profilePageUrl);

        objMainPage.clickConstructorLink();

        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась главная страница",objMainPage.checkMainPageShown(mainPageUrl));
    }

    @Test
    @Step("Проверь переход в личном кабинете на логотип Stellar Burgers")
    public void runTestLogotypeLink()  {
// сначала надо создать клиента и авторизоваться
        ProfilePage objProfilePage = new ProfilePage(browserRule.getWebDriver());
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        objProfilePage.openProfilePage(profilePageUrl);

        objProfilePage.clickStellarBurgersLink();

        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница главная страница",objMainPage.checkMainPageShown(mainPageUrl));
    }





}
