package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void userIsOnWikipediaHomePage() {
        Driver.getDriver().get("https://en.wikipedia.org");
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchKeyword) {
        wikiSearchPage.searchBox.sendKeys(searchKeyword);
    }

    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String searchKeyword) {
        String expectedTitle = searchKeyword + " - Wikipedia";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);
        //Assert.assertTrue(Driver.getDriver().getTitle().contains(searchKeyword));
    }



    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String searchKeyword) {
        String expectedTitle = searchKeyword;
        String actualTitle = wikiSearchPage.mainHeader.getText();

        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);

        //Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(searchKeyword));
        //Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String searchKeyword) {
        Assert.assertTrue(wikiSearchPage.imageHeader.getText().equals(searchKeyword));
    }
}
