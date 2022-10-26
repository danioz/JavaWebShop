package org.example.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriverWait wait;
    protected WebDriver driver;

    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void isDisplayed();
}
