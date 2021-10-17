package com.test.framework.pom.pages;

import com.test.framework.pom.base.BasePage;
import com.test.framework.pom.objects.BillingAddress;
import com.test.framework.pom.objects.User;
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

    private final By clickHeroToLoginLink = By.className("showlogin");
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.name("login");

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterTextIntoNameField(String text) {
        driver.findElement(billingFirstName).clear();
        driver.findElement(billingFirstName).sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoLastNameField(String text) {
        driver.findElement(billingLastName).clear();
        driver.findElement(billingLastName).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoAddressField(String text) {
        driver.findElement(billingAddress).clear();
        driver.findElement(billingAddress).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntocityField(String text) {
        driver.findElement(billingCity).clear();
        driver.findElement(billingCity).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoPostCodeField(String text) {
        driver.findElement(billingPostcode).clear();
        driver.findElement(billingPostcode).sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoEmailField(String text) {
        driver.findElement(billingEmail).clear();
        driver.findElement(billingEmail).sendKeys(text);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress) {
        return enterTextIntoNameField(billingAddress.getFirstName())
                .enterTextIntoLastNameField(billingAddress.getLastName())
                .enterTextIntoAddressField(billingAddress.getAddressLineOne())
                .enterTextIntocityField(billingAddress.getCity())
                .enterTextIntoPostCodeField(billingAddress.getPostalCode())
                .enterTextIntoEmailField(billingAddress.getEmail());
    }

    public CheckOutPage clickOnPlaceOrderBtn() {
        waitForOverlaysToDissapear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(successfulMessage).getText();
    }

    public CheckOutPage clickOnLoginLink() {
        driver.findElement(clickHeroToLoginLink).click();
        return this;
    }

    public CheckOutPage enterTextIntoUsernameField(String text) {
        driver.findElement(username).sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoPasswordField(String text) {
        driver.findElement(password).sendKeys(text);
        return this;
    }

    public CheckOutPage clickOnLoginBtn() {
        driver.findElement(loginBtn).click();
        return this;

    }

    public CheckOutPage login(User user) {
        return enterTextIntoUsernameField(user.getUsername())
                .enterTextIntoPasswordField(user.getPassword())
                .clickOnLoginBtn();
    }


}
