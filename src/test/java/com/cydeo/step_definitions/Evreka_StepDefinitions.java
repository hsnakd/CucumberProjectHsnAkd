package com.cydeo.step_definitions;

import com.cydeo.pages.EvrekaPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Evreka_StepDefinitions {
    EvrekaPage evrekaPage = new EvrekaPage();
    String searchKey = "";


    @When("Check that the {string} are listed")
    public void check_that_the_results_are_listed(String expectedResult) {
        String actualResult = evrekaPage.searchResult.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }



    @Given("user is on Amazon search page")
    public void user_is_on_amazon_search_page() {
        Driver.getDriver().get("https://www.amazon.com.tr/");
        if(evrekaPage.acceptCookies.isDisplayed()){
            evrekaPage.acceptCookies.click();
        }
    }
    @When("user search {string} and clicks enter")
    public void user_search_and_clicks_enter(String searchKey) {
        evrekaPage.searchBox.sendKeys( searchKey + Keys.ENTER);

    }
    @When("Click iPhone13 at the top of the list")
    public void click_i_phone13_at_the_top_of_the_list() {
        evrekaPage.iPhone13.click();

    }
    @Then("User should see brand in the result")
    public void user_should_see_brand_in_the_result() {
        String brand = evrekaPage.brand.getText();
        System.out.println("Marka : " + brand);
    }
    @Then("User should see model in the result")
    public void user_should_see_model_in_the_result() {
        String model = evrekaPage.model.getText();
        System.out.println("Model : " + model);
    }
    @Then("User should see size in the result")
    public void user_should_see_size_in_the_result() {
        String size  = evrekaPage.size.getText();
        System.out.println("Size : " + size);
    }
    @Then("User should see color in the result")
    public void user_should_see_color_in_the_result() {
        String color = evrekaPage.color.getText();
        System.out.println("Color : " + color);
    }
    @Then("User should see price in the result")
    public void user_should_see_price_in_the_result() {
        String price = evrekaPage.price.getText();
        System.out.println("Price : " + price);
    }
    @Then("User should see stock in the result")
    public void user_should_see_stock_in_the_result() {
        String stock = evrekaPage.stock.getText();
        System.out.println("Stock : " + stock);
    }



}
