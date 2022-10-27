package org.example.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CreditCard implements IPaymentMethod{

    @FindBy(css = "#paymentmethod_2")
    private WebElement ccPaymentCheckbox;

    @FindBy(css = "#CreditCardType")
    private WebElement creditCard;

    @FindBy(css = "#CardholderName")
    private WebElement cardHolderName;

    @FindBy(css = "#CardholderName")
    private WebElement cardNumber;

    @FindBy(css = "#ExpireMonth")
    private WebElement expirationMonth;

    @FindBy(css = "#ExpireYear")
    private WebElement expirationYear;

    @FindBy(css = "#CardCode")
    private WebElement cardCode;

    private Buttons buttons;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        //todo
        this.ccPaymentCheckbox.click();
        this.buttons.pressContinue("continueButtonPaymentMethod");
        Select creditCardDrp = new Select(this.creditCard);
        creditCardDrp.selectByIndex(1);
        this.cardHolderName.sendKeys(paymentDetails.get(""));
        this.cardNumber.sendKeys(paymentDetails.get(""));
        Select monthDrpD = new Select(this.expirationMonth);
        monthDrpD.selectByIndex(2);
        Select yearDrpD = new Select(this.expirationYear);
        yearDrpD.selectByIndex(2);
        this.cardCode.sendKeys(paymentDetails.get(""));
        this.buttons.pressContinue("continueButtonPaymentInformation");
    }
}
