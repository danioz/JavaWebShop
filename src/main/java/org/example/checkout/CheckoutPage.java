package org.example.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CheckoutPage {

    private WebDriver driver;

    private IPaymentMethod paymentMethod;

    private Buttons buttons;

    public CheckoutPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, Buttons.class);
    }

    public void setPaymentMethod(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        PageFactory.initElements(driver, this.paymentMethod);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentMethod.enterPaymentInformation(paymentDetails);
    }
}
