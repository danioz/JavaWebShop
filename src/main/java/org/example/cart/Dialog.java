package org.example.cart;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Dialog extends AbstractComponent {

    @FindBy(css = ".ui-button-icon-primary.ui-icon.ui-icon-closethick")
    private WebElement closeDialog;

    public Dialog(WebDriver driver) {
        super(driver);
    }

    public CartPage closeDialog() {
        this.closeDialog.click();
        return new CartPage(driver);
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.closeDialog.isDisplayed()));
    }
}
