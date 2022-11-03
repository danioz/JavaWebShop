package org.example.test;

import org.example.checkout.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void checkoutTest(IPaymentMethod paymentMethod, Map<String, String> paymentDetails) {
        homePage
                .goTo()
                .getHeaderBar()
                .proceedToLogin()
                .getReturningCustomer()
                .logInToApplication("d.zet@gmail.test.com", "Password1234!");
        homePage
                .getCategories()
                .isDisplayed();
        homePage
                .getCategories()
                .selectCategory("Apparel & Shoes");
        productsPage
                .getProducts()
                .isDisplayed();
        productsPage
                .getProducts()
                .selectProduct("Blue Jeans");
        productsPage
                .getItem()
                .isDisplayed();
        productsPage
                .getItem()
                .addQuantity(2)
                .clickAddToCart();
        homePage
                .getHeaderBar()
                .proceedToShoppingCart();
        cartPage
                .getCheckout()
                .isDisplayed();
        cartPage
                .getCheckout()
                .checkoutCart();
        cartPage
                .getDialog()
                .isDisplayed();
        cartPage
                .getDialog()
                .closeDialog()
                .getCheckout()
                .acceptTerms()
                .getCheckout()
                .checkoutCart();
        checkoutPage
                .getButtons()
                .pressContinue("Billing")
                .pressContinue("Shipping")
                .pressContinue("ShippingMethod");
        checkoutPage
                .setPaymentMethod(paymentMethod);
        checkoutPage
                .pay(paymentDetails);
        checkoutPage
                .getButtons()
                .pressContinue("PaymentInformation");
        checkoutPage.getButtons()
                .pressConfirm();
        checkoutPage
                .getCompleted()
                .isDisplayed();
        checkoutPage
                .getCompleted()
                .validateOrderNumber()
                .validateSuccessNotification("Your order has been successfully processed!")
                .proceedToHomePage();
        homePage
                .getHeaderBar()
                .logout();

    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = new HashMap<>();
        cc.put("creditCard", "Visa");
        cc.put("cardHolder", "DanioZet");
        cc.put("cardNumber", "12345678978");
        cc.put("expirationMonth", "8");
        cc.put("expirationYear", "2023");
        cc.put("cardCode", "123");

        Map<String, String> cod = new HashMap<>();
        cod.put("message", "You will pay by COD");

        Map<String, String> po = new HashMap<>();
        po.put("purchaseOrderNumber", "123456789");

        Map<String, String> ck = new HashMap<>();
        ck.put("message", "Mail Personal or Business Check, Cashier's Check or money order to:");

        return new Object[][]{
                {new CreditCard(driver), cc},
                {new CashOnDelivery(driver), cod},
                {new PurchaseOrder(driver), po},
                {new Check(driver), ck}
        };
    }
}
