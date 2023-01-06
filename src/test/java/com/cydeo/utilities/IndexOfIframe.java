package com.cydeo.utilities;

import com.cydeo.pages.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class IndexOfIframe {
    public static void main(String[] args) {

        BasePage basePage = new BasePage();

        Driver.getDriver().get("http://demo.guru99.com/test/guru99home/");

        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        int size = Driver.getDriver().findElements(By.tagName("iframe")).size();

        for(int i=0; i<=size; i++){
            Driver.getDriver().switchTo().frame(i);
            int iframeNumber = Driver.getDriver().findElements(By.xpath("html/body/a/img")).size();
            if (iframeNumber == 1) {
                System.out.println("iframeNumber" + i);
            }

            Driver.getDriver().switchTo().defaultContent();
        }
    }

    @And("Add a start time")
    public void findFrameNumber() {
        BasePage basePage = new BasePage();
        BrowserUtils.iframe((By) basePage.img);

    }
}

