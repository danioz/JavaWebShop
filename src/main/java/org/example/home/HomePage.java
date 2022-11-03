package org.example.home;

import org.example.common.Categories;
import org.example.common.HeaderBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private HeaderBar headerBar;
    private Categories categories;

    public HomePage(final WebDriver driver) {
        this.driver= driver;
        this.headerBar = PageFactory.initElements(driver, HeaderBar.class);
        this.categories = PageFactory.initElements(driver, Categories.class);
    }

    public HomePage goTo() {
        this.driver.get("https://demowebshop.tricentis.com/");
        return this;
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }

    public Categories getCategories() {
        return categories;
    }
}
