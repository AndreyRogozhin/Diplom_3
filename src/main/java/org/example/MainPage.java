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

    // ссылка на КОнструктор
    private final By constructorLink = By.xpath(".//a/p[text()='Конструктор']");
    // найти такой a, у которого в дочернем теге есть текст "Конструктор"


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




    /*
    //раздел "Вопросы о важном"  - локатор раздела
   private final By listOfFAQ = By.className("Home_FAQ__3uVm4");

   public MainPage(WebDriver driver) {
        this.driver = driver;}


//  нажатие верхней кнопки "Заказать"
   public void clickOrderUpperButton(){
        driver.findElement(orderUpperButton).click();
    }


    // прокрутить до нижней кнопки "Заказать"
    public void scrollToOrderLowerButton(){
        WebElement element = driver.findElement(orderLowerButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    // прокрутить до вопросов о важном
   public void scrollToListOfFAQ(){
       WebElement element = driver.findElement(listOfFAQ);
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
   }

   public String findAnswerByQuestion(String questionText){
       By question = By.xpath(".//div[@class='accordion__button' and text()='"+ questionText +"']");
       driver.findElement(question).click();
       String attrib = driver.findElement(question).getAttribute("id");
       int idNum = attrib.lastIndexOf("-");
       String idNumStr = attrib.substring(idNum+1);
       String attribAnswer = "accordion__panel-" + idNumStr;
       String answerXPath = ".//div[@id='"+attribAnswer+"']/p";

       By answer = By.xpath(answerXPath);

       return driver.findElement(answer).getText() ;

   }




основные страницы и объекты



https://stellarburgers.nomoreparties.site/ingredient/61c0c5a71d1f82001bdaaa78
 «Булки»,«Соусы»,  «Начинки».


какие нужны объекты и методы







Андрей
userAR001@mail.ru 1-8




*/
}
