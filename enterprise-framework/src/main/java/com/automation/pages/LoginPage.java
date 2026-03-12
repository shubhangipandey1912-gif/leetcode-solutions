package com.automation.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public void openApplication() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public boolean isInventoryPageDisplayed() {
    return getCurrentUrl().contains("inventory");
}
}