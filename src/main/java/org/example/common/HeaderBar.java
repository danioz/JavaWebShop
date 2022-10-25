package org.example.common;

import org.example.home.HomePage;
import org.example.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBar extends AbstractComponent{

    @FindBy(css = ".ico-login")
    private WebElement logInLink;

    @FindBy(css = ".ico-logout")
    private WebElement logOutLink;

    @FindBy(css = ".ico-register")
    private WebElement registerLink;

    @FindBy(css = "a.ico-cart > .cart-label")
    private WebElement shoppingCartLink;

    @FindBy(css = "div[class='header-links'] a[class='account']")
    private WebElement accountLink;

    public HeaderBar(final WebDriver driver) {
        super(driver);
    }

    public LoginPage proceedToLogin() {
         this.logInLink.click();
         return new LoginPage(driver);
    }

    public HomePage logOUt() {
         this.logOutLink.click();
         return new HomePage(driver);
    }

    public LoginPage proceedToRegister() {
         this.registerLink.click();
         return new LoginPage(driver);
    }

    public void proceedToShoppingCart() {
         this.shoppingCartLink.click();
    }

    public boolean isLoggedUser(String email) {
        return this.accountLink.getText().equalsIgnoreCase(email);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.logInLink.isDisplayed());
    }
}
