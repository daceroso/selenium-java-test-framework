package com.test.framework;


import com.test.framework.pom.base.BaseTest;
import com.test.framework.pom.pages.CartPage;
import com.test.framework.pom.pages.CheckOutPage;
import com.test.framework.pom.pages.HomePage;
import com.test.framework.pom.pages.StorePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.search("Blue");
        assertThat(storePage.getTitle()).contains("Blue");

        storePage.clickOnAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickOnViewCart();
        assertThat(cartPage.getProductName()).isEqualTo("Blue Shoes");

        CheckOutPage checkOutpage = cartPage.clickOnCheckOutBtn();







        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("example@example.com");
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(5000);

        assertThat(driver.findElement(By.cssSelector(".woocommerce-notice")).getText()).isEqualTo("Thank you. Your order has been received.");




    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/daceros/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();

        assertThat(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText()).contains("Blue");

        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        assertThat(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText()).isEqualTo("Blue Shoes");

        driver.findElement(By.cssSelector(".checkout-button")).click();

        driver.findElement(By.className("showlogin")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("demo@demo.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.id("billing_first_name")).clear();

        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(3000);

        assertThat(driver.findElement(By.cssSelector(".woocommerce-notice")).getText()).isEqualTo("Thank you. Your order has been received.");

        driver.quit();


    }
}
