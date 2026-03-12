package com.automation.stepdefinitions;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("User launches the application")
    public void user_launches_the_application() {
        loginPage = new LoginPage();
        loginPage.openApplication();
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to inventory page")
    public void user_should_be_redirected_to_inventory_page() {
        Assertions.assertTrue(
                loginPage.isInventoryPageDisplayed(),
                "Login failed - Inventory page not displayed"
        );
    }
}