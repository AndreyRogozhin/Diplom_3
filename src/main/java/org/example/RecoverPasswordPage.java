package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoverPasswordPage {
    private WebDriver driver;

    /*
    Восстановление пароля
     */

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;}


    // кнопка «Восстановить» - локатор
    private final By recoverPasswordButton = By.xpath(".//button[text()='Восстановить']");

    // ввод почты
    private final By email = By.xpath(".//input[text()='Зарегистрироваться']");

    public void clickRecoverPasswordButton(){
        driver.findElement(recoverPasswordButton).click();
    }

    public void setEmail(String email){
        driver.findElement(this.email).sendKeys(email);
    }

    private final By loginLink = By.xpath(".//a[@href='/login']");

    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }

    public void openRecoverPasswordPage (String recoverPasswordPageUrl){
        driver.get(recoverPasswordPageUrl);
    }




}
