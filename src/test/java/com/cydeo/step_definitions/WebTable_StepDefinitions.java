package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebTable_StepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();


    @Given("user is on the login page of web table app")
    public void userIsOnTheLoginPageOfWebTableApp() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }


    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        webTableLoginPage.inputUsername.sendKeys(username);
    }


    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        webTableLoginPage.inputPassword.sendKeys(password);
    }


    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {
        BrowserUtils.verifyURLContains("orders");

    }


}
