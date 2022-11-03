package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Buttons extends AbstractComponent {

    @FindBy(css = "input[onclick='Billing.save()']")
    private WebElement continueButtonBilling;
    @FindBy(css = "input[onclick='Shipping.save()']")
    private WebElement continueButtonShipping;
    @FindBy(css = "input[class='button-1 shipping-method-next-step-button']")
    private WebElement continueButtonShippingMethod;
    @FindBy(css = "input[class='button-1 payment-method-next-step-button']")
    private WebElement continueButtonPaymentMethod;
    @FindBy(css = "input[class='button-1 payment-info-next-step-button']")
    private WebElement continueButtonPaymentInformation;

    @FindBy(css = "input[value='Confirm']")
    private WebElement confirmButton;

    public Buttons(WebDriver driver) {
        super(driver);
    }

    public void pressConfirm(){
        this.wait.until((d) -> this.confirmButton.isDisplayed());
        this.confirmButton.click();
    }

    public Buttons pressContinue(String continueButton) {
        Map<String, WebElement> buttons = new HashMap<>();

        buttons.put("Billing", continueButtonBilling);
        buttons.put("Shipping", continueButtonShipping);
        buttons.put("ShippingMethod", continueButtonShippingMethod);
        buttons.put("PaymentMethod", continueButtonPaymentMethod);
        buttons.put("PaymentInformation", continueButtonPaymentInformation);

        this.wait.until((d) -> buttons.get(continueButton).isDisplayed());
        buttons.get(continueButton).click();
        return this;
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.continueButtonBilling.isDisplayed()));
    }
}
