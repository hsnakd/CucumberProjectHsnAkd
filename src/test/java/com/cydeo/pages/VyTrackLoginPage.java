package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement loginUsername;

    @FindBy(id = "prependedInput2")
    public WebElement loginPassword;

    @FindBy(id = "_submit")
    public WebElement loginButton;



}
