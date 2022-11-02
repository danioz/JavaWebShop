package org.example.test;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void openHomePage() {
        homePage.goTo()
                .getHeaderBar()
                .isDisplayed();
    }

    @Test(dependsOnMethods = "openHomePage")
    public void registerTest() {
        homePage.getHeaderBar()
                .proceedToRegister()
                .getPersonalDetails()
                .isDisplayed();

        registerPage.getPersonalDetails()
                .registerNewUser(userData)
                .getConfirmation()
                .verifyRegisterNotification("Your registration completed");

        homePage.getHeaderBar()
                .validateLoggedUser(userData.geteMail());
    }
}
