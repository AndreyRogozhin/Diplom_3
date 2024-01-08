package org.example;

import org.openqa.selenium.*;

public class RegisterPage {
    private WebDriver driver;


/*
Страница регистрации
поля имя, почта, пароль
кнопка Зарегистрироваться и по ней переход на страницу логина

 */

    private final By name = By.xpath(".//label[text()='Имя']/parent::*/input");
    private final By email = By.xpath(".//label[text()='Email']/parent::*/input");
    private final By password = By.xpath(".//label[text()='Пароль']/parent::*/input");

    private final By passwordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");


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

    public void setPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }


    public void openRegisterPage(String registerPageUrl){
        driver.get(registerPageUrl);
    }

    public boolean passwordErrorMessageFound(){
        Boolean result;
        try {
            driver.findElement(passwordErrorMessage);
        }
        catch (NoSuchElementException exception)
        {
           return false;
        }
        return true;
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;}





}