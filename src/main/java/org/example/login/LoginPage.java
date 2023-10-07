package org.example.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final ReturningCustomer returningCustomer;

    public LoginPage(final WebDriver driver) {
        this.returningCustomer = PageFactory.initElements(driver, ReturningCustomer.class);
    }

    public ReturningCustomer getReturningCustomer() {
        return returningCustomer;
    }
}
