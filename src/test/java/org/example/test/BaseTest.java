package org.example.test;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.utils.UserModel;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;
    protected ProductsPage productsPage;
    protected RegisterPage registerPage;


    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);;
        this.driver.manage().window().maximize();
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
