package org.example;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.apiobject.Credentials;
import org.example.apiobject.User;
import org.example.apiobject.UserClient;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.example.apiobject.UserGenerator.randomUser;



public class TestRegisterPage {


    @Rule
    public BrowserRule browserRule = new BrowserRule();
    String registerPageUrl = Url.REGISTER_PAGE;
    String loginPageUrl = Url.LOGIN_PAGE;

    @Test
    @Step("Успешная регистрация")
    public void runTestRegisterPageOK() {

        RestAssured.baseURI = Url.MAIN_PAGE;
        User user = randomUser();

        UserClient userClient = new UserClient();
        Response response;
        Credentials credentials = user.credsFromUser();


        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());
        objRegisterPage.openRegisterPage(registerPageUrl);

        objRegisterPage.setEmail(credentials.getEmail());
        objRegisterPage.setPassword(credentials.getPassword());
        objRegisterPage.setName(credentials.getName());

        objRegisterPage.clickRegisterButton();
        objLoginPage.waitForLoadLoginPage();

        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(loginPageUrl));

        response = userClient.login(credentials);
        String token = response.path("accessToken");
        response = userClient.delete(token);


    }

    @Test
    @Step("Ошибка регистрации по причине слишком короткого пароля")
    public void runTestRegisterPageBadPassword() {

        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());
        objRegisterPage.openRegisterPage(registerPageUrl);


        objRegisterPage.setEmail("www2@yandex.ru");
        objRegisterPage.setName("fff");
        objRegisterPage.setPassword("fff");

        objRegisterPage.clickRegisterButton();
        Assert.assertTrue("Нет сообщения об ошибке!", objRegisterPage.passwordErrorMessageFound());


    }

    @Test
    @Step("Вход через кнопку в форме регистрации")
    public void runTestEnterButtonLink() {
        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getWebDriver());

        objRegisterPage.openRegisterPage(registerPageUrl);

        objRegisterPage.clickEnterButton();
        objLoginPage.waitForLoadLoginPage();

        Assert.assertTrue("Не открылась страница авторизации", objLoginPage.checkLoginPageShown(loginPageUrl));

    }


}
