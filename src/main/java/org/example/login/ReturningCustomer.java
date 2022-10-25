package org.example.login;

import org.apache.commons.logging.Log;
import org.example.common.AbstractComponent;
import org.example.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturningCustomer extends AbstractComponent {

    @FindBy(css = "#Email")
    private WebElement emailTextBox;

    @FindBy(css = "#Password")
    private WebElement passwordTextBox;

    @FindBy(css = ".login-button")
    private WebElement loginButton;

    public ReturningCustomer(final WebDriver driver) {
        super(driver);
    }

    public HomePage logInToApplication(String email, String password) {
        this.emailTextBox.sendKeys(email);
        this.passwordTextBox.sendKeys(password);
        this.loginButton.click();
        return new HomePage(driver);
    }

    public ReturningCustomer enterNotValidCredentials(String email, String password) {
        this.emailTextBox.sendKeys(email);
        this.passwordTextBox.sendKeys(password);
        this.loginButton.click();
        return new LoginPage(driver).getReturningCustomer();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.loginButton.isDisplayed());
    }
}
