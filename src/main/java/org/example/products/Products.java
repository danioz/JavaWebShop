package org.example.products;

import org.example.common.AbstractComponent;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Products extends AbstractComponent {

    @FindBy(className = "product-item")
    private List<WebElement> products;
    @FindBy(xpath = "//li[@class='next-page']/a")
    private WebElement nextButton;



    public Products(WebDriver driver) {
        super(driver);
    }

    public Products selectProduct(String productName){
        List<WebElement> lookedUpProduct;
        do {
            lookedUpProduct = this.products
                    .stream()
                    .filter(element -> element.getText().contains(productName))
                    .collect(Collectors.toList());
            if(lookedUpProduct.isEmpty() && nextButton.isDisplayed())
                nextButton.click();
            if(lookedUpProduct.isEmpty() && !nextButton.isDisplayed())
                throw new InvalidArgumentException("There is n such product in catalog.");
        } while (lookedUpProduct.isEmpty());

        lookedUpProduct.get(0).click();
        return this;
    }





    @Override
    public void isDisplayed() {
        //todo?
        Assert.assertTrue(this.wait.until((d) -> this.products.stream().filter(WebElement::isDisplayed).findFirst().orElse(null).isDisplayed()));
    }
}
