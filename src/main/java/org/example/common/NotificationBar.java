package org.example.common;

import org.example.home.HomePage;
import org.example.cart.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NotificationBar extends AbstractComponent {

    @FindBy(css = "#bar-notification")
    private WebElement notificationBar;

    @FindBy(css = "#bar-notification > .close")
    private WebElement closeButton;

    public NotificationBar(WebDriver driver) {
        super(driver);
    }

    public void validateNotication(String notification) {
        Assert.assertTrue(this.notificationBar
                .findElement(By.cssSelector("p.content"))
                .getText()
                .equalsIgnoreCase(notification));
    }

    public CartPage proceedToShoppingCart() {
        this.notificationBar
                .findElement(By.cssSelector("p.content > a"))
                .click();
        return new CartPage(driver);
    }

    public HomePage closeBar() {
        this.closeButton.click();
        return new HomePage(driver);
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.notificationBar.isDisplayed()));
    }
}
