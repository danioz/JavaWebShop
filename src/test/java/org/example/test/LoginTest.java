package org.example.test;

import org.example.home.HomePage;
import org.example.login.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Test
    public void openHomePage() {
        homePage.goTo()
                .getHeaderBar()
                .isDisplayed();
    }

    @Test(dataProvider = "getData", dependsOnMethods = "openHomePage")
    public void loginTest(String email, String password) {

        homePage.getHeaderBar()
                .proceedToLogin()
                .getReturningCustomer()
                .isDisplayed();

        loginPage.getReturningCustomer()
                .logInToApplication(email, password)
                .getHeaderBar()
                .validateLoggedUser(email);
    }

    @DataProvider
    public Object[][] getData() {

        return new Object[][]{
                {"d.zet@gmail.test.com", "Password1234!"}
        };


    }
}
