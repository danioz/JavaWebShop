package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Map;

public class CreditCard extends AbstractComponent implements IPaymentMethod{

    @FindBy(css = "#paymentmethod_2")
    private WebElement ccPaymentCheckbox;

    @FindBy(css = "#CreditCardType")
    private WebElement creditCard;

    @FindBy(css = "#CardholderName")
    private WebElement cardHolderName;

    @FindBy(css = "#CardNumber")
    private WebElement cardNumber;

    @FindBy(css = "#ExpireMonth")
    private WebElement expirationMonth;

    @FindBy(css = "#ExpireYear")
    private WebElement expirationYear;

    @FindBy(css = "#CardCode")
    private WebElement cardCode;

    private Buttons buttons;

    public CreditCard(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.wait.until((d) ->this.ccPaymentCheckbox.isDisplayed());
        this.ccPaymentCheckbox.click();
        this.buttons.pressContinue("PaymentMethod");

        this.wait.until((d) ->this.creditCard.isDisplayed());
        new Select(this.creditCard).selectByValue(paymentDetails.get("creditCard"));
        this.cardHolderName.sendKeys(paymentDetails.get("cardHolder"));
        this.cardNumber.sendKeys(paymentDetails.get("cardNumber"));
        new Select(this.expirationMonth).selectByValue(paymentDetails.get("expirationMonth"));
        new Select(this.expirationYear).selectByValue(paymentDetails.get("expirationYear"));
        this.cardCode.sendKeys(paymentDetails.get("cardCode"));
    }

    @Override
    public void setContinueButtons(Buttons buttons) {
        this.buttons = buttons;
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.creditCard.isDisplayed()));
    }
}
