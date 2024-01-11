package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private final By divisionSauceTab = By.xpath(".//span[text()='Соусы']");
//        private final By divisionBunTab = By.xpath(".//span[text()='Булки']/parent::div");
    private final By divisionBunTab = By.xpath(".//span[text()='Булки']");

    private final By divisionFillingTab = By.xpath(".//span[text()='Начинки']");
    // click buttons

    // ссылка на Конструктор
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']//parent::a");
    // найти такой <a>, у которого в дочернем теге есть текст "Конструктор"



    private final By currentBunTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Булки']");
    private final By currentSauceTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Соусы']");
    private final By currentFillingTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Начинки']");



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

    public void clickDivisionSauceTab() throws InterruptedException {

        Thread.sleep(500,0);
        WebElement element = driver.findElement(divisionSauceTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

//        driver.findElement(divisionSauceTab).click();
    }

    public void clickDivisionBunTab() throws InterruptedException {
        WebElement element = driver.findElement(divisionBunTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

//       driver.findElement(divisionBunTab).click();
    }

    public void clickDivisionFillingTab() throws InterruptedException {
//            driver.findElement(divisionFillingTab).click();
        Thread.sleep(500,0);
        WebElement element = driver.findElement(divisionFillingTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }




    public void openMainPage (String mainPageUrl){
        driver.get(mainPageUrl);
    }


    public boolean checkMainPageShown (String mainPageUrl){
        boolean found =  driver.getCurrentUrl().equals( mainPageUrl);
        return found;
    }


    public boolean tabBunIsCurrent(){
        Boolean result;
        try {
            driver.findElement(currentBunTab);
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
        return true;
    }

    public boolean tabFillingIsCurrent(){
        Boolean result;
        try {
            driver.findElement(currentFillingTab);
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
        return true;
    }

    public boolean tabSauceIsCurrent(){
        Boolean result;
        try {
            driver.findElement(currentSauceTab);
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
        return true;
    }



//    .//div[contains(class,'tab_tab_type_current__2BEPc' )]/span[text()='Соусы']

    /*

    // прокрутить до вопросов о важном
   public void scrollToListOfFAQ(){
       WebElement element = driver.findElement(listOfFAQ);
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
   }

*/
}
