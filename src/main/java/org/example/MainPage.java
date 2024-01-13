package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    // кнопка «Войти в аккаунт» - локатор
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

/*
Главная страница

 */
    // кнопка «Оформить заказ» - локатор
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    //кнопка «Личный кабинет»
    private final By enterProfileLink = By.xpath(".//a[@href='/account']");
    //    переходы к разделам «Булки»,«Соусы»,  «Начинки».
    private final By divisionSauceTab = By.xpath(".//span[text()='Соусы']");
    // click reference
    //        private final By divisionBunTab = By.xpath(".//span[text()='Булки']/parent::div");
    private final By divisionBunTab = By.xpath(".//span[text()='Булки']");
    private final By divisionFillingTab = By.xpath(".//span[text()='Начинки']");
    // ссылка на Конструктор
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']//parent::a");
    // click buttons
    private final By currentBunTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Булки']");
    // найти такой <a>, у которого в дочернем теге есть текст "Конструктор"
    private final By currentSauceTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Соусы']");
    private final By currentFillingTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc' )]/span[text()='Начинки']");
    private final WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }


    // click button Войт в аккаунт
    public void clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
    }

    // click button Личный кабинет
    public void clickEnterProfileLink() {
        driver.findElement(enterProfileLink).click();
    }

    public void clickDivisionSauceTab() throws InterruptedException {
        driver.findElement(divisionSauceTab).click();
    }

    public void clickDivisionBunTab() throws InterruptedException {
        driver.findElement(divisionBunTab).click();
    }

    public void clickDivisionFillingTab() throws InterruptedException {
        driver.findElement(divisionFillingTab).click();
    }


    public void openMainPage(String mainPageUrl) {
        driver.get(mainPageUrl);
    }


    public boolean checkMainPageShown(String mainPageUrl) {
        boolean found = driver.getCurrentUrl().equals(mainPageUrl);
        return found;
    }


    public boolean tabBunIsCurrent() {
        Boolean result;
        try {
            driver.findElement(currentBunTab);
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    public boolean tabFillingIsCurrent() {
        Boolean result;
        try {
            driver.findElement(currentFillingTab);
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    public boolean tabSauceIsCurrent() {
        Boolean result;
        try {
            driver.findElement(currentSauceTab);
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }


    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public void waitForLoadMainPageNotAuthorised() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }



}
