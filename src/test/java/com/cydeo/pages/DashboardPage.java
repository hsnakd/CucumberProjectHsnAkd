package com.cydeo.pages;

import com.cydeo.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2")
    public WebElement pageLabel;

    @FindBy(xpath = "//button[.=\"View all orders\"]")
    public WebElement allOrderBtn;

    @FindBy(xpath = "//button[.=\"View all products\"]")
    public  WebElement allProBtn;

    @FindBy(xpath = "//button[.=\"Order\"]")
    public WebElement orderBtn;

    @FindBy(xpath = "//button[.=\"Logout\"]")
    public WebElement logoutBtn;

    @FindBy(xpath = "//button[.=\"Select All\"]")
    public WebElement selectBtn;

    @FindBy(xpath = "//button[.=\"Deselect All\"]")
    public WebElement deselctBtn;


}
