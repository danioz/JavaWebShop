package org.example.checkout;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Completed extends AbstractComponent {

    @FindBy(css = "div[class='title'] strong")
    private WebElement successfulNotification;

    @FindBy(css = "div[class='master-wrapper-main'] li:nth-child(1)")
    private WebElement orderNumber;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    public Completed(WebDriver driver) {
        super(driver);
    }

    public Completed validateOrderNumber() {
        Assert.assertTrue(this.wait.until((d) -> this.orderNumber.isDisplayed()));
        return this;
    }

    public Completed validateSuccessNotification(String notification) {
        Assert.assertTrue(this.successfulNotification.getText().trim().equalsIgnoreCase(notification));
        return this;
    }

    public void proceedToHomePage() {
        this.continueButton.click();
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.continueButton.isDisplayed()));
    }
}
