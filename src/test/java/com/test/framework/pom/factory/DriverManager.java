package com.test.framework.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
       // WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        WebDriver driver = new ChromeDriver();
       // WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }
}
