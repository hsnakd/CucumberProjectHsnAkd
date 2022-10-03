package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
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
        String url = ConfigurationReader.getProperty("web.table.url");
        Driver.getDriver().get(url);
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

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
        webTableLoginPage.inputUsername.sendKeys(username);
        webTableLoginPage.inputPassword.sendKeys(password);
        webTableLoginPage.loginButton.click();

    //    webTableLoginPage.login(username, pw);

    }





}
