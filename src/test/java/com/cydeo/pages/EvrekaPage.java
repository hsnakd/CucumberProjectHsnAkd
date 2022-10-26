package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvrekaPage {
    //#1-Create constructor and instantiate driver and object of the class

    public EvrekaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//img[@data-image-index='1']")
    public WebElement iPhone13;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchResult;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-success']")
    public WebElement stock;

    @FindBy(xpath = "//td[@class='a-span9']/span")
    public WebElement brand;

    @FindBy(xpath = "(//td[@class='a-span9']/span) [2]")
    public WebElement model;

    @FindBy(xpath = "//p[.='512 GB']")
    public WebElement model2;

    @FindBy(xpath = "//*[@id=\"variation_size_name\"]/div/span")
    public WebElement size;

    @FindBy(xpath = "//span[.='512 GB']")
    public WebElement size2;

    @FindBy(xpath = "//span[@class='selection']")
    public WebElement size3;

    @FindBy(xpath = "//*[@id=\"variation_color_name\"]/div/span")
    public WebElement color;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public WebElement price;

    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    public WebElement price5;

    @FindBy(xpath = "//span[@class='a-offscreen']")
    public WebElement price4;

    @FindBy(xpath = "//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span/span[1]")
    public WebElement price2;

    @FindBy(xpath = "//span[@id=\"tp_price_block_total_price_ww\"]/span[1]")
    public WebElement price3;

}
