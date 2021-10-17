package com.test.framework.pom.pages;

import com.test.framework.pom.base.BasePage;
import com.test.framework.pom.objects.BillingAddress;
import com.test.framework.pom.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstName));
        element.clear();
        element.sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoLastNameField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingLastName));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoAddressField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntocityField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCity));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoPostCodeField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostcode));
        element.clear();
        element.sendKeys(text);
        return this;
    }


    public CheckOutPage enterTextIntoEmailField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmail));
        element.clear();
        element.sendKeys(text);
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

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulMessage)).getText();
    }

    public CheckOutPage clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(clickHeroToLoginLink)).click();
        return this;
    }

    public CheckOutPage enterTextIntoUsernameField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public CheckOutPage enterTextIntoPasswordField(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public CheckOutPage clickOnLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;

    }

    public CheckOutPage login(User user) {
        return enterTextIntoUsernameField(user.getUsername())
                .enterTextIntoPasswordField(user.getPassword())
                .clickOnLoginBtn();
    }


}
