package com.test.framework.pom.pages;

import com.test.framework.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

/*
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkOutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");
*/
    @FindBy(css = "td[class='product-name'] a")
    private WebElement productName;

    @FindBy(css = ".checkout-button")
    private WebElement checkOutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, CartPage.class);
    }


    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();

    }

    public CheckOutPage checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
        return new CheckOutPage(driver);
    }
}
