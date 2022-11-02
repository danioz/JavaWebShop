package org.example.test;

import org.example.checkout.CreditCard;
import org.example.checkout.IPaymentMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTest extends BaseTest {

    @Test
    public void openHomePage() {
        homePage.goTo()
                .getHeaderBar()
                .isDisplayed();
    }

    @Test(dataProvider = "getLoginData", dependsOnMethods = "openHomePage")
    public void loginAsUser(String email, String password) {
        homePage.getHeaderBar()
                .proceedToLogin()
                .getReturningCustomer()
                .isDisplayed();

        loginPage.getReturningCustomer()
                .logInToApplication(email, password)
                .getHeaderBar()
                .validateLoggedUser(email);
    }

    @Test(dataProvider = "getData", dependsOnMethods = "loginAsUser")
    public void checkoutTest(IPaymentMethod paymentMethod, Map<String, String> paymentDetails) {
        this.homePage.goTo();
        this.homePage.getCategories().isDisplayed();
        this.homePage.getCategories()
                .selectCategory("Apparel & Shoes"); //todo
        this.productsPage.getProducts().isDisplayed();
        this.productsPage.getProducts()
                .selectProduct("Blue Jeans"); //todo
        this.productsPage.getItem().isDisplayed();
        this.productsPage.getItem()
//                .selectSize("M")
                .addQuantity(2)
                .clickAddToCart();
        this.homePage.getHeaderBar().proceedToShoppingCart();
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
        //todo
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

    @DataProvider
    public Object[][] getLoginData() {

        return new Object[][]{
                {"d.zet@gmail.test.com", "Password1234!"}
        };
    }
}
