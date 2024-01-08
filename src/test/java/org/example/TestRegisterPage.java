package org.example;

import org.example.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestRegisterPage {


    private WebDriver driver;
    String registerPageUrl = Url.REGISTER_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;


    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void runTestRegisterPageOK()  {


//        driver.get(registerPageUrl);


//        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRegisterPage.openRegisterPage(registerPageUrl);

        // проверить переход по нажатию на кнопку Зарегистрироваться
        // нужно придумать случайное имя пользователя, почту и пароль. Пароль - длинный, более 5 символов
        objRegisterPage.setEmail("www2@yandex.ru");
        objRegisterPage.setPassword("ffffff");
        objRegisterPage.setName("fff");

        objRegisterPage.clickRegisterButton();

        // !!!! после успешной регистрации нужно удалить пользователя !!!


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
