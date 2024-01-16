package org.example;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;


public class TestMainPage {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Вход по кнопке «Войти в аккаунт»")
    public void runTestClickEnterAccountLink() {

        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());


        objMainPage.openMainPage(Url.MAIN_PAGE);
        objMainPage.clickEnterAccountButton();

        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(Url.LOGIN_PAGE));
    }


    @Test
    @Step("Вход по кнопке «Войти в личный кабинет»")
    public void runTestClickProfileLink() {

        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());


        objMainPage.openMainPage(Url.MAIN_PAGE);
        objMainPage.clickEnterProfileLink();

        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(Url.LOGIN_PAGE));
    }


    @Test
    @Step("Переход на закладку Булки")
    public void runTestClickBunTab() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(Url.MAIN_PAGE);

        objMainPage.clickDivisionFillingTab();
        objMainPage.clickDivisionBunTab();

        Assert.assertTrue("Не получился переход на булки", objMainPage.tabBunIsCurrent());
    }

    @Test
    @Step("Переход на закладку Соусы")
    public void runTestClickSauceTab() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(Url.MAIN_PAGE);
        objMainPage.clickDivisionSauceTab();

        Assert.assertTrue("Не получился переход на соусы", objMainPage.tabSauceIsCurrent());
    }

    @Test
    @Step("Переход на закладку Начинки")
    public void runTestClickFillingTab() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getWebDriver());

        objMainPage.openMainPage(Url.MAIN_PAGE);
        objMainPage.clickDivisionFillingTab();

        Assert.assertTrue("Не получился переход на начинки", objMainPage.tabFillingIsCurrent());
    }


}
