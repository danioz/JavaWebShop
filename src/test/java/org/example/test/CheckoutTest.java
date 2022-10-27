package org.example.test;

import org.example.cart.CartPage;
import org.example.checkout.CheckoutPage;
import org.example.checkout.CreditCard;
import org.example.checkout.IPaymentMethod;
import org.example.home.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeTest
    public void setPages() {
        this.homePage = new HomePage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.cartPage = new CartPage(driver);
    }

    @Test(dataProvider = "getData")
    public void checkoutTest(IPaymentMethod paymentMethod, Map<String, String> paymentDetails) {
        this.homePage.goTo();
        this.cartPage.getCheckout().isDisplayed();
        this.cartPage.getCheckout()
                .checkoutCart();
        this.cartPage.getDialog().isDisplayed();
        this.cartPage.getDialog()
                .closeDialog()
                .getCheckout()
                .acceptTerms()
                .getCheckout()
                .checkoutCart();
        this.checkoutPage.setPaymentMethod(paymentMethod);
        this.checkoutPage.pay(paymentDetails);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = new HashMap<>();
        //todo
        cc.put("", "");

        return new Object[][]{
                {new CreditCard(), cc}
        };
    }
}
