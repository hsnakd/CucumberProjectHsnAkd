package com.cydeo.pages;

import com.cydeo.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VyTrackDashboardPage {

    public VyTrackDashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class=\"unclickable\"]")
    public List<WebElement> menus;

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;
}
