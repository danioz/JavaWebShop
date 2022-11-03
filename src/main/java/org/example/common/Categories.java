package org.example.common;

import org.example.home.HomePage;
import org.example.products.ProductsPage;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Categories extends AbstractComponent {

    @FindBy(css = ".block-category-navigation .list li")
    private List<WebElement> categories;

    public Categories(WebDriver driver) {
        super(driver);
    }

    public ProductsPage selectCategory(String categoryName) {
        List<WebElement> temp = categories
                .stream()
                .filter(webElement -> webElement.getText().contains(categoryName))
                .collect(Collectors.toList());

        if (temp.isEmpty()) throw new InvalidArgumentException("Invalid category name.");
        temp.get(0).click();
        return new ProductsPage(driver);
    }

    @Override
    public void isDisplayed() {

    }
}
