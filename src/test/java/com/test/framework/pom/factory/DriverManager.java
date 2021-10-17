package com.test.framework.pom.factory;

import com.test.framework.pom.constans.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {


    public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
        switch (BrowserType.valueOf(browser)) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
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
