package com.cydeo.step_definitions;

import com.cydeo.pages.*;
import com.cydeo.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Dashboard_StepDefinition {

    @Given("user is loged in")
    public void user_is_loged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
        TableLoginPage loginPage = new TableLoginPage();
        String username = ConfigurationReader.getProperty("web.table.username");
        String password = ConfigurationReader.getProperty("web.table.pw");
        loginPage.login(username,password);
    }
    @Then("user should see below contents")
    public void user_should_see_below_contents(List<String> contents) {
        DashboardPage dbPage = new DashboardPage();
        List<String> actual = new ArrayList<>();
        actual.add(dbPage.pageLabel.getText());
        actual.add(dbPage.allOrderBtn.getText());
        actual.add(dbPage.allProBtn.getText());
        actual.add(dbPage.orderBtn.getText());
        actual.add(dbPage.logoutBtn.getText());
        actual.add(dbPage.selectBtn.getText());
        actual.add(dbPage.deselctBtn.getText());

        Assert.assertEquals(contents,actual);
    }
}
