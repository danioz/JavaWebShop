package org.example.test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.cart.CartPage;
import org.example.checkout.CheckoutPage;
import org.example.home.HomePage;
import org.example.login.LoginPage;
import org.example.products.ProductsPage;
import org.example.register.RegisterPage;
import org.example.utils.RandomUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.utils.UserModel;

public class BaseTest {

    protected WebDriver driver;
    protected Faker faker;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;
    protected ProductsPage productsPage;
    protected RegisterPage registerPage;
    protected UserModel userData;

    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        faker = new Faker();
        this.userData = RandomUser.generateRandomUser();
    }
    @BeforeTest
    public void setupPages() {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.cartPage = new CartPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.registerPage = new RegisterPage(driver);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
