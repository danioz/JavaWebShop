package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Map;

public class Check extends AbstractComponent implements IPaymentMethod {

    @FindBy(css = "#paymentmethod_1")
    private WebElement ccPaymentCheckbox;

    @FindBy(css = "div.section.payment-info p:first-of-type")
    private WebElement notification;

    private Buttons buttons;

    public Check(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.wait.until((d) ->this.ccPaymentCheckbox.isDisplayed());
        this.ccPaymentCheckbox.click();
        this.buttons.pressContinue("PaymentMethod");
        this.wait.until((d) ->this.notification.isDisplayed());
        Assert.assertTrue(this.notification.getText().trim().equalsIgnoreCase(paymentDetails.get("message")));
    }

    @Override
    public void setContinueButtons(Buttons buttons) {
        this.buttons = buttons;
    }

    @Override
    public void isDisplayed() {
        this.wait.until((d) ->this.ccPaymentCheckbox.isDisplayed());
    }
}
