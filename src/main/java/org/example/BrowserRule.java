package org.example;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    protected void before() {
        //
        // driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //TimeUnit timeUnit = ;
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3),);

        // перешли на страницу тестового приложения
        //driver.get(Url.MAIN_PAGE);
    }

    @Override
    protected void after() {
        driver.quit();
    }
}