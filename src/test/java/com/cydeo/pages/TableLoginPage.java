package com.cydeo.pages;

import com.cydeo.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableLoginPage {

    public TableLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement btn;

    public  void login(String username, String password){


        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        btn.click();
    }



}
