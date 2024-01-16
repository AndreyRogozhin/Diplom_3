package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    // кнопка «Восстановить» - локатор
    private final By recoverPasswordButton = By.xpath(".//button[text()='Восстановить']");

    /*
    Восстановление пароля
     */
    // ввод почты
    private final By email = By.xpath(".//input[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath(".//a[@href='/login']");
    private final WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void openRecoverPasswordPage(String recoverPasswordPageUrl) {
        driver.get(recoverPasswordPageUrl);
    }


}
