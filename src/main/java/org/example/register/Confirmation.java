package org.example.register;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Confirmation extends AbstractComponent {

    @FindBy(className = "result")
    private WebElement registerNotification;

    public Confirmation(WebDriver driver) {
        super(driver);
    }

    public String getRegisterNotification() {
        return registerNotification.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.registerNotification.isDisplayed());
    }
}
