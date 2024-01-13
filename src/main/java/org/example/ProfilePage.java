package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Личный кабинет
 */

public class ProfilePage {

    // кнопка «Выход» - локатор
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    // ссылка на КОнструктор
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']/parent::a");
    // переход на главную строницу по нажатию на логотип
    private final By stellarBurgersLink = By.xpath(".//a[@href='/']");
    // найти такой a, у которого в дочернем теге есть текст "Конструктор"
    private final WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStellarBurgersLink() {
        driver.findElement(stellarBurgersLink).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public boolean checkProfilePageShown(String profilePageUrl) {
        return driver.getCurrentUrl().equals(profilePageUrl);
    }

    public void openProfilePage(String profilePageUrl) {
        driver.get(profilePageUrl);
    }

    public void waitForLoadProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

}
