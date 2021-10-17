package com.test.framework.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {


    public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
        switch (browser) {
            case "Chrome" -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        }

        // WebDriverManager.firefoxdriver().cachePath("Drivers").setup();

        // WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }
}
