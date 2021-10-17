package com.test.framework;


import com.test.framework.pom.base.BaseTest;
import com.test.framework.pom.objects.BillingAddress;
import com.test.framework.pom.objects.Product;
import com.test.framework.pom.objects.User;
import com.test.framework.pom.pages.CartPage;
import com.test.framework.pom.pages.CheckOutPage;
import com.test.framework.pom.pages.HomePage;
import com.test.framework.pom.pages.StorePage;
import com.test.framework.pom.utils.JacksonUtils;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search(searchFor);
        assertThat(storePage.getTitle()).isEqualTo("Search results: “" + searchFor + "”");

        storePage.clickOnAddToCartBtn(product.getName());
        CartPage cartPage = storePage.clickOnViewCart();
        assertThat(cartPage.getProductName()).isEqualTo(product.getName());

        CheckOutPage checkOutpage = cartPage
                .checkout()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickOnPlaceOrderBtn();


        assertThat(checkOutpage.getNotice()).isEqualTo("Thank you. Your order has been received.");


    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException {

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);

        Product product = new Product(1215);
        User user = new User("user", "123");

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search(searchFor);
        assertThat(storePage.getTitle()).isEqualTo("Search results: “" + searchFor + "”");

        storePage.clickOnAddToCartBtn(product.getName());

        CartPage cartPage = storePage.clickOnViewCart();
        assertThat(cartPage.getProductName()).isEqualTo(product.getName());

        CheckOutPage checkOutpage = cartPage.checkout();
        checkOutpage.clickOnLoginLink();
        checkOutpage
                .login(user)
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickOnPlaceOrderBtn();


        assertThat(checkOutpage.getNotice()).isEqualTo("Thank you. Your order has been received.");
    }
}
