package com.test.framework;


import com.test.framework.pom.base.BaseTest;
import com.test.framework.pom.pages.CartPage;
import com.test.framework.pom.pages.CheckOutPage;
import com.test.framework.pom.pages.HomePage;
import com.test.framework.pom.pages.StorePage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");
        assertThat(storePage.getTitle()).contains("Blue");

        storePage.clickOnAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickOnViewCart();
        assertThat(cartPage.getProductName()).isEqualTo("Blue Shoes");

        CheckOutPage checkOutpage = cartPage.checkout();
        checkOutpage.enterTextIntoNameField("demo")
                .enterTextIntoLastNameField("user")
                .enterTextIntoAddressField("San Francisco")
                .enterTextIntocityField("San Francisco")
                .enterTextIntoPostCodeField("94188")
                .enterTextIntoEmailField("example@example.com")
                .clickOnPlaceOrderBtn();
        Thread.sleep(5000);


        assertThat(checkOutpage.getNotice()).isEqualTo("Thank you. Your order has been received.");


    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");
        assertThat(storePage.getTitle()).contains("Blue");

        storePage.clickOnAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickOnViewCart();
        assertThat(cartPage.getProductName()).isEqualTo("Blue Shoes");

        CheckOutPage checkOutpage = cartPage.checkout();
        checkOutpage.clickOnLoginLink();
        Thread.sleep(5000);
        checkOutpage
                .login("user", "123")
                .enterTextIntoNameField("demo")
                .enterTextIntoLastNameField("user")
                .enterTextIntoAddressField("San Francisco")
                .enterTextIntocityField("San Francisco")
                .enterTextIntoPostCodeField("94188")
                .enterTextIntoEmailField("example@example.com")
                .clickOnPlaceOrderBtn();

        Thread.sleep(3000);

        assertThat(checkOutpage.getNotice()).isEqualTo("Thank you. Your order has been received.");
    }
}
