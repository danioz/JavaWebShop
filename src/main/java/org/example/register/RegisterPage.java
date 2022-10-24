package org.example.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;
    private PersonalDetails personalDetails;
    private Confirmation confirmation;

    public RegisterPage(final WebDriver driver){
        this.driver = driver;
        this.personalDetails = PageFactory.initElements(driver, PersonalDetails.class);
        this.confirmation = PageFactory.initElements(driver, Confirmation.class);
    }

    public PersonalDetails getPersonalDetails() {
        return this.personalDetails;
    }

    public Confirmation getConfirmation() {
        return this.confirmation;
    }
}
