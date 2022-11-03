package org.example.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private WebDriver driver;

    private Products products;
    private Item item;

    public ProductsPage(final WebDriver driver) {
        this.driver = driver;
        this.products = PageFactory.initElements(driver, Products.class);
        this.item = PageFactory.initElements(driver, Item.class);
    }

    public Products getProducts() {
        return products;
    }

    public Item getItem() {
        return item;
    }
}
