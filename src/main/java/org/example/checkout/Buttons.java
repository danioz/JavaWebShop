package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        this.confirmButton.click();
    }

    public void pressContinue(String continueButton) {
        Map<String, WebElement> buttons = new HashMap<>();

        buttons.put("continueButtonBilling", continueButtonBilling);
        buttons.put("continueButtonShipping", continueButtonShipping);
        buttons.put("continueButtonShippingMethod", continueButtonShippingMethod);
        buttons.put("continueButtonPaymentMethod", continueButtonPaymentMethod);
        buttons.put("continueButtonPaymentInformation", continueButtonPaymentInformation);

        buttons.get(continueButton).click();
    }


    @Override
    public void isDisplayed() {

    }
}
