package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;}




    private final By email = By.xpath(".//input[@name='name']");
    private final By password = By.xpath(".//input[@name='Пароль']");

    public void setEmail(String email){
                driver.findElement(this.email).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }

    private final By enterButton = By.xpath(".//button[text()='Войти']");
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }

    public void openLoginPage (String loginPageUrl){
        driver.get(loginPageUrl);
    }


    //   .//input[@name="name"]

    public boolean checkLoginPageShown (String loginPageUrl){
        return  driver.getCurrentUrl().equals( loginPageUrl);
    }

}
