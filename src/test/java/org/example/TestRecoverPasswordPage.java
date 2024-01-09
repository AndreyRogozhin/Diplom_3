package org.example;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TestRecoverPasswordPage {


    private WebDriver driver;
    String recoverPasswordPageUrl = Url.REGISTER_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;


    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @Step("Вход через кнопку в форме восстановления пароля")
    public void runTestRecoverPasswordPageOK()  {

        RecoverPasswordPage objRecoverPasswordPage = new RecoverPasswordPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRecoverPasswordPage.openRecoverPasswordPage(recoverPasswordPageUrl);


        objRecoverPasswordPage.clickLoginLink();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown (loginPageUrl));
    }
}
