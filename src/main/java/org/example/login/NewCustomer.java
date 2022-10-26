package org.example.login;

import org.example.common.AbstractComponent;
import org.example.register.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewCustomer extends AbstractComponent {

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    public NewCustomer(final WebDriver driver) {
        super(driver);
    }

    public RegisterPage proceedToRegister() {
        this.registerButton.click();
        return new RegisterPage(driver);
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.registerButton.isDisplayed()));
    }
}
