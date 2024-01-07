package org.example;

import org.example.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestRegisterPage {


    private WebDriver driver;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void runTestRegisterPageGoodPassword()  {

//        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());

        // проверить переход по нажатию на кнопку Зарегистрироваться

        String registerPageUrl = Url.REGISTER_PAGE;

        objRegisterPage.setEmail("www");
        objRegisterPage.setPassword("fff");
        objRegisterPage.setName("ffffff");

        objRegisterPage.clickRegisterButton();


        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
     //   Assert.assertTrue("По нажатию нижней кнопки не открылась страница для оформления заказа",objOrderPage.checkOrderPageShown(orderPageUrl));

    }

    @Test
    public void runTestRegisterPageBadPassword()  {

//        MainPage objMainPage = new MainPage(browserRule.getWebDriver());
        RegisterPage objRegisterPage = new RegisterPage(browserRule.getWebDriver());

        // проверить переход по нажатию на кнопку Зарегистрироваться

        String registerPageUrl = Url.REGISTER_PAGE;

        objRegisterPage.setEmail("www");
        objRegisterPage.setPassword("fff");
        objRegisterPage.setName("fff");

        objRegisterPage.clickRegisterButton();

        Boolean result = objRegisterPage.passwordErrorMessageFound();


//        objMainPage.clickOrderLowerButton();

        // дождаться открытия страницы
        // проверить, что открылась страница с первой формой для заполнения
        Assert.assertTrue("Нет сообщения об ошибке!",result);

    }




}
