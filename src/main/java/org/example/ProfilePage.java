package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Личный кабинет
 */

public class ProfilePage {

    private WebDriver driver;

    // кнопка «Выход» - локатор
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    // ссылка на КОнструктор
    private final By constructorLink = By.xpath(".//a/p[text()='Конструктор']");
    // найти такой a, у которого в дочернем теге есть текст "Конструктор"


    // переход на главную строницу по нажатию на логотип
    private final By stellarBurgersLink = By.xpath(".//a/p[text()='Конструктор']");
    // пока непонятно, как искать этот элемент

    public void stellarBurgersLink(){
        driver.findElement(stellarBurgersLink).click();
    }

    public void clickConstructorLink(){
        driver.findElement(constructorLink).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }


    public ProfilePage(WebDriver driver) {
        this.driver = driver;}



}
