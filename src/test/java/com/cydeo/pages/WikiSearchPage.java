package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    //create constructor
    // initialize the driver instance and this class' instance using PageFactory.initElements
    public WikiSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //We can start locating web elements using @FindBy annotation
    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='searchButton']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@style='display:inline']")
    public WebElement imageHeader;

}
