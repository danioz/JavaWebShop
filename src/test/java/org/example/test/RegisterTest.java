package org.example.test;

import com.github.javafaker.Faker;

import org.example.home.HomePage;
import org.example.register.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);

    }

    @Test
    public void registerTest() {
        homePage.goTo();
        Assert.assertTrue(homePage.getHeaderBar().isDisplayed());

        homePage.getHeaderBar().proceedToRegister();
        Assert.assertTrue(registerPage.getPersonalDetails().isDisplayed());

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String eMail = fName+"."+lName+"@gmail.test";

        registerPage.getPersonalDetails().registerNewUser("M", fName, lName, eMail, "Pass1234!", "Pass1234!");

        Assert.assertEquals(registerPage.getConfirmation().getRegisterNotification(), "Your registration completed");
        Assert.assertEquals(homePage.getHeaderBar().getLoggedUser(), eMail);

    }
}
