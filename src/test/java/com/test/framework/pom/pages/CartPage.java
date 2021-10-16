package com.test.framework.pom.pages;

import com.codeborne.selenide.conditions.Checked;
import com.test.framework.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkOutBtn = By.cssSelector(".checkout-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public String getProductName() {
        return driver.findElement(productName).getTagName();
    }

    public CheckOutPage clickOnCheckOutBtn() {
        driver.findElement(checkOutBtn).click();

        return new CheckOutPage(driver);
    }
}
