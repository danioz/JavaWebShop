package org.example.test;

import org.example.home.HomePage;
import org.example.register.RegisterPage;
import org.example.utils.RandomUser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.utils.UserModel;

public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;
    private UserModel userData;

    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);
        this.userData = RandomUser.generateRandomUser();
    }

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
