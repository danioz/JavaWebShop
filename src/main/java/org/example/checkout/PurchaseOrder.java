package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PurchaseOrder extends AbstractComponent implements IPaymentMethod {

    @FindBy(css = "#paymentmethod_3")
    private WebElement ccPaymentCheckbox;

    @FindBy(css = "#PurchaseOrderNumber")
    private WebElement purchaseOrderNumber;

    private Buttons buttons;

    public PurchaseOrder(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.wait.until((d) ->this.ccPaymentCheckbox.isDisplayed());
        this.ccPaymentCheckbox.click();
        this.buttons.pressContinue("PaymentMethod");
        this.wait.until((d) ->this.purchaseOrderNumber.isDisplayed());
        this.purchaseOrderNumber.sendKeys(paymentDetails.get("purchaseOrderNumber"));
    }

    @Override
    public void setContinueButtons(Buttons buttons) {
        this.buttons = buttons;
    }

    @Override
    public void isDisplayed() {
//todo
    }
}
