package org.example.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final Dialog dialog;
    private final Checkout checkout;

    public CartPage(final WebDriver driver) {
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
