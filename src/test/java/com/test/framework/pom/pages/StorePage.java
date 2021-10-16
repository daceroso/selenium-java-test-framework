package com.test.framework.pom.pages;

import com.test.framework.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public StorePage search(String text) {
        enterTextInSearchField(text).clickOnSearchBtn();
        return this;
    }
    private StorePage clickOnSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void clickOnAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }


}
