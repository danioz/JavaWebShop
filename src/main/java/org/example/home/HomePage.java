package org.example.home;

import org.example.common.HeaderBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private HeaderBar headerBar;

    public HomePage(final WebDriver driver) {
        this.driver= driver;
        this.headerBar = PageFactory.initElements(driver, HeaderBar.class);
    }

    public void goTo() {
        this.driver.get("https://demowebshop.tricentis.com/");
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}
