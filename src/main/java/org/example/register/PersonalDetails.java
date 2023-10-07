package org.example.register;

import org.example.common.AbstractComponent;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.utils.UserModel;

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

    public RegisterPage registerNewUser(UserModel userData){
        switch (userData.getGender()){
            case "M":
                maleButton.click();
                break;
            case "F":
                femaleButton.click();
                break;
            default:
                throw new InvalidArgumentException("Gender field value is invalid.");
        }
        this.firstName.sendKeys(userData.getfName());
        this.lastName.sendKeys(userData.getlName());
        this.email.sendKeys(userData.geteMail());
        this.password.sendKeys(userData.getPassword());
        this.confirmedPassword.sendKeys(userData.getPassword());
        this.registerButton.click();
        return new RegisterPage(driver);
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> email.isDisplayed()));
    }
}
