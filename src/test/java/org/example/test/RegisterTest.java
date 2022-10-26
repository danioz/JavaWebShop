package org.example.test;

import org.example.home.HomePage;
import org.example.register.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.example.utils.RandomUser;
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
    public void registerTest() {
        homePage.goTo();
        Assert.assertTrue(homePage.getHeaderBar().isDisplayed());

        homePage.getHeaderBar().proceedToRegister();
        Assert.assertTrue(registerPage.getPersonalDetails().isDisplayed());

        registerPage.getPersonalDetails().registerNewUser(userData);

        Assert.assertTrue(registerPage.getConfirmation().verifyRegisterNotification("Your registration completed"));
        Assert.assertTrue(homePage.getHeaderBar().isLoggedUser(userData.geteMail()));

    }
}
