package org.example.register;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Confirmation extends AbstractComponent {

    @FindBy(className = "result")
    private WebElement registerNotification;

    public Confirmation(WebDriver driver) {
        super(driver);
    }

    public void verifyRegisterNotification(String notification) {
        Assert.assertTrue(registerNotification.getText().trim().equalsIgnoreCase(notification));
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.registerNotification.isDisplayed()));
    }
}
