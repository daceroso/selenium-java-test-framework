package com.test.framework.pom.pages;

import com.test.framework.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    private final By billingFirstName = By.id("billing_first_name");
    private final By billingLastName = By.id("billing_last_name");
    private final By billingAddress = By.id("billing_address_1");
    private final By billingCity = By.id("billing_city");
    private final By billingPostcode = By.id("billing_postcode");
    private final By billingEmail = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successfulMessage = By.cssSelector(".woocommerce-notice");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterTextIntoNameField(String text){
        driver.findElement(billingFirstName).sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoLastNameField(String text) {
        driver.findElement(billingLastName).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoAddressField(String text) {
        driver.findElement(billingAddress).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntocityField(String text) {
        driver.findElement(billingCity).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoPostCodeField(String text) {
        driver.findElement(billingPostcode).sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoEmailField(String text) {
        driver.findElement(billingEmail).sendKeys(text);
        return this;
    }

    public CheckOutPage clickOnPlaceOrderBtn() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(successfulMessage).getText();
    }


}
