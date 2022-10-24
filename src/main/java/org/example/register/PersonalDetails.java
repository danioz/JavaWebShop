package org.example.register;

import org.example.common.AbstractComponent;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetails extends AbstractComponent {

    @FindBy(css = "#gender-male")
    private WebElement maleButton;

    @FindBy(css = "#gender-male")
    private WebElement femaleButton;

    @FindBy(css = "#FirstName")
    private WebElement firstName;

    @FindBy(css = "#LastName")
    private WebElement lastName;

    @FindBy(css = "#Email")
    private WebElement email;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmedPassword;

    @FindBy(css = "#register-button")
    private WebElement registerButton;

    public PersonalDetails(WebDriver driver) {
        super(driver);
    }

    public void registerNewUser(String gender, String firstName, String lastName, String eMail, String password, String confirmPassword){
        switch (gender){
            case "M":
                maleButton.click();
                break;
            case "F":
                femaleButton.click();
                break;
            default:
                throw new InvalidArgumentException("Gender field value is invalid.");
        }
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(eMail);
        this.password.sendKeys(password);
        this.confirmedPassword.sendKeys(confirmPassword);
        this.registerButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.email.isDisplayed());
    }
}
