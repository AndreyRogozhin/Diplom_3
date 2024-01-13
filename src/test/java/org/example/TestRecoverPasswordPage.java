package org.example;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TestRecoverPasswordPage {


    @Rule
    public BrowserRule browserRule = new BrowserRule();
    String recoverPasswordPageUrl = Url.RECOVER_PASSWORD_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;
    private WebDriver driver;

    @Test
    @Step("Вход через кнопку в форме восстановления пароля")
    public void runTestRecoverPasswordPageOK() {

        RecoverPasswordPage objRecoverPasswordPage = new RecoverPasswordPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRecoverPasswordPage.openRecoverPasswordPage(recoverPasswordPageUrl);


        objRecoverPasswordPage.clickLoginLink();
        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(loginPageUrl));
    }
}
