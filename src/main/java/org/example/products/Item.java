package org.example.products;

import org.example.common.AbstractComponent;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Item extends AbstractComponent {

    @FindBy(xpath = "//input[contains(@name, 'addtocart_')]")
    private WebElement quantityInput;
    @FindBy(xpath = "//select[contains(@id, 'product_attribute_')]")
    private WebElement sizeList;
    @FindBy(xpath = "//input[contains(@id, 'add-to-cart-button')]")
    private WebElement addToCartButton;

    public Item(WebDriver driver) {
        super(driver);
    }

    public Item addQuantity(int howMuch) {
        quantityInput.clear();
        quantityInput.sendKeys(howMuch+"");
        return this;
    }

    public Item selectSize(String sizeName) {
        Select drpSize = new Select(sizeList);
        switch (sizeName){
            case "Large":
                drpSize.selectByValue("34");
                break;
            case "Small":
                drpSize.selectByValue("32");
                break;
            case "Medium":
                drpSize.selectByValue("33");
                break;
            case "X-Large":
                drpSize.selectByValue("35");
                break;
            default:
                throw new InvalidArgumentException("Invalid size.");
        }

        return  this;
    }

    public Item clickAddToCart(){
        addToCartButton.click();
        return this;
    }

    @Override
    public void isDisplayed() {
        Assert.assertTrue(this.wait.until((d) -> this.addToCartButton.isDisplayed()));
    }
}
