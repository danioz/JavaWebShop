package org.example.cart;

import org.example.checkout.CheckoutPage;
import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Checkout extends AbstractComponent {

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    @FindBy(css = "#termsofservice")
    private WebElement termOfServiceCheck;

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage checkoutCart() {
        this.checkoutButton.click();
        return new CheckoutPage(driver);
    }

    public CartPage acceptTerms() {
        this.termOfServiceCheck.click();
        return new CartPage(driver);
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.checkoutButton.isDisplayed()));
    }
}
