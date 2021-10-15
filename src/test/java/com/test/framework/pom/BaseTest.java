package com.test.framework.pom;

import com.test.framework.factory.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;


    @Before
    public void startDriver() {
        driver = new DriverManager().initializeDriver();
    }


    @After
    public void quitDriver() {
        driver.quit();
    }
}
