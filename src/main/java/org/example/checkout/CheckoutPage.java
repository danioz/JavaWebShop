package org.example.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CheckoutPage {

    private final WebDriver driver;

    private IPaymentMethod paymentMethod;

    private final Buttons buttons;

    private final Completed completed;

    public CheckoutPage(final WebDriver driver) {
        this.driver = driver;
        this.buttons = PageFactory.initElements(driver, Buttons.class);
        this.completed = PageFactory.initElements(driver, Completed.class);
    }

    public void setPaymentMethod(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        PageFactory.initElements(driver, this.paymentMethod);
        this.paymentMethod.setContinueButtons(PageFactory.initElements(driver, Buttons.class));
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentMethod.enterPaymentInformation(paymentDetails);
    }

    public Buttons getButtons() {
        return buttons;
    }

    public Completed getCompleted() {
        return completed;
    }
}
