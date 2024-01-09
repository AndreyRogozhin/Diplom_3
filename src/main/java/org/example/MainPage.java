package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

/*
Главная страница

 */


    // кнопка «Войти в аккаунт» - локатор
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //кнопка «Личный кабинет»
    private final By enterProfileLink = By.xpath(".//a[@href='/account']");
    // click reference

//    переходы к разделам «Булки»,«Соусы»,  «Начинки».
    private final By divisionSauceLink = By.xpath(".//span[text()='Соусы']");
    private final By divisionBunLink = By.xpath(".//span[text()='Булки']");
    private final By divisionFillingLink = By.xpath(".//span[text()='Начинки']");
    // click buttons

    // ссылка на Конструктор
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']//parent::a");
    // найти такой <a>, у которого в дочернем теге есть текст "Конструктор"


    public MainPage(WebDriver driver) {
        this.driver = driver;}

    public void clickConstructorLink(){
        driver.findElement(constructorLink).click();
    }


    // click button Войт в аккаунт
    public void clickEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }

    // click button Личный кабинет
    public void clickEnterProfileLink(){
        driver.findElement(enterProfileLink).click();
    }


    public void clickDivisionSauceLink(){
        driver.findElement(divisionSauceLink).click();
    }

    public void clickDivisionBunLink(){
        driver.findElement(divisionBunLink).click();
    }

    public void clickDivisionFillingLink(){
        driver.findElement(divisionFillingLink).click();
    }


    public void openMainPage (String mainPageUrl){
        driver.get(mainPageUrl);
    }


    public boolean checkMainPageShown (String mainPageUrl){
        return  driver.getCurrentUrl().equals( mainPageUrl);
    }





    /*

    // прокрутить до вопросов о важном
   public void scrollToListOfFAQ(){
       WebElement element = driver.findElement(listOfFAQ);
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
   }


основные страницы и объекты



https://stellarburgers.nomoreparties.site/ingredient/61c0c5a71d1f82001bdaaa78
 «Булки»,«Соусы»,  «Начинки».






+Успешную регистрацию.
+Ошибку для некорректного пароля. Минимальный пароль — шесть символов.

вход по кнопке «Войти в аккаунт» на главной,
вход через кнопку «Личный кабинет»,
+вход через кнопку в форме регистрации,
+вход через кнопку в форме восстановления пароля.


Проверь переход по клику на «Личный кабинет».


+ 	Проверь переход по клику на «Конструктор»
+и на логотип Stellar Burgers.

Выход из аккаунта
+Проверь выход по кнопке «Выйти» в личном кабинете.

Раздел «Конструктор»
Проверь, что работают переходы к разделам:
«Булки»,
«Соусы»,
«Начинки».


*/
}
