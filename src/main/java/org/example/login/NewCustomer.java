package org.example.login;

import org.example.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomer extends AbstractComponent {

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    public NewCustomer(final WebDriver driver) {
        super(driver);
    }

    public void proceedToRegister() {
        this.registerButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.registerButton.isDisplayed());
    }
}
