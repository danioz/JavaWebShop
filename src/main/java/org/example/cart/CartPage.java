package org.example.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    private Dialog dialog;
    private Checkout checkout;

    public CartPage(final WebDriver driver) {
        this.driver = driver;
        this.checkout = PageFactory.initElements(driver, Checkout.class);
        this.dialog = PageFactory.initElements(driver, Dialog.class);
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public Dialog getDialog() {
        return dialog;
    }
}
