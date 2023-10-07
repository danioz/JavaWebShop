package org.example.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private final Products products;
    private final Item item;

    public ProductsPage(final WebDriver driver) {
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
