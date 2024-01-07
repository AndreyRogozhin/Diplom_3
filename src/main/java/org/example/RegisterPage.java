package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;


/*
Страница регистрации
поля имя, почта, пароль
кнопка Зарегистрироваться и по ней переход на страницу логина

 */

    private final By name = By.xpath(".//input[text()='Зарегистрироваться']");
    private final By email = By.xpath(".//input[text()='Зарегистрироваться']");
    private final By password = By.xpath(".//input[text()='Зарегистрироваться']");

    private final By passwordErrorMessage = By.xpath(".//input[text()='Некорректный пароль']");


    // кнопка «Войти в аккаунт» - локатор
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // click button Войт в аккаунт
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void setName(String name){
        driver.findElement(this.name).sendKeys(name);
    }

    public void setEmail(String email){
        driver.findElement(this.email).sendKeys(email);
    }

    public boolean passwordErrorMessageFound(){
        Boolean result;
        driver.findElement(passwordErrorMessage) ;
        return false;
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;}

    public void setPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }




}