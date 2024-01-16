package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By email = By.xpath(".//input[@name='name']");
    private final By password = By.xpath(".//input[@name='Пароль']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void openLoginPage(String loginPageUrl) {
        driver.get(loginPageUrl);
    }


    public boolean checkLoginPageShown(String loginPageUrl) {
        return driver.getCurrentUrl().equals(loginPageUrl);
    }

}
