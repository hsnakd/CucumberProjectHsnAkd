package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DataTable_StepDefinitions {
    @Then("user should see fruits I like")
    public void userShouldSeeFruitsILike(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    //----------------------------------------------------------------------------------------
    DropdownsPage dropdownsPage = new DropdownsPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        /**       Driver.getDriver().get("https://practice.cydeo.com/dropdown");        */

        String environment = System.getProperty("environment");

        if (environment != null) {
            switch (environment) {
                case "qa":
                    Driver.getDriver().get("https://practice.cydeo.com/dropdown");
                    break;
                case "dev":
                    Driver.getDriver().get("http://dev.vytrack.com");
                    break;
                case "stage":
                    Driver.getDriver().get("http://stage.vytrack.com");
                    break;
            }
        } else {
            String url = ConfigurationReader.getProperty("environment");
            Driver.getDriver().get(url);
        }

    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        //This method will return us the List of String of given dropdown's options
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);
        //Assert will check the size of the lists first. If it is matching it will check content 1 by 1.

    }


}


