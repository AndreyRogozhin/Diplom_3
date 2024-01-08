package org.example;

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
    public void runTestRecoverPasswordPageOK()  {


//        driver.get(registerPageUrl);


//        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        RecoverPasswordPage objRecoverPasswordPage = new RecoverPasswordPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRecoverPasswordPage.openRecoverPasswordPage(recoverPasswordPageUrl);


        objRecoverPasswordPage.clickLoginLink();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Не открылась страница авторизации",objLoginPage.checkLoginPageShown (loginPageUrl));

    }

    @Test
    public void runTestRegisterPageBadPassword()  {

//        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRegisterPage.openRegisterPage(registerPageUrl);

        // проверить переход по нажатию на кнопку Зарегистрироваться

        String registerPageUrl = Url.REGISTER_PAGE;

        // нужно придумать случайное имя пользователя, почту и пароль. Пароль - короткий, менее 6 символов
        objRegisterPage.setEmail("www2@yandex.ru");
        objRegisterPage.setName("fff");
        objRegisterPage.setPassword("fff");

        objRegisterPage.clickRegisterButton();
        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Нет сообщения об ошибке!",objRegisterPage.passwordErrorMessageFound());

    }




}
