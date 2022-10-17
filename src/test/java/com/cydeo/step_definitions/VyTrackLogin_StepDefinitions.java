package com.cydeo.step_definitions;

import com.cydeo.pages.*;
import com.cydeo.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VyTrackLogin_StepDefinitions {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }


    @Then("check  the credentials and write pass or fail")
    public void checkTheCredentialsAndWritePassOrFail() throws IOException {
            String filePath = "src/test/resources/source/VyTrackQa2Users.xlsx";
            FileInputStream in = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheet("vyTrack");


            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                String userName  = sheet.getRow(i).getCell(0).toString();
                String passWord  = sheet.getRow(i).getCell(1).toString();
                String firstName = sheet.getRow(i).getCell(2).toString();
                String lastName  = sheet.getRow(i).getCell(3).toString();

                loginPage.loginUsername.sendKeys(userName);
                loginPage.loginPassword.sendKeys(passWord);
                loginPage.loginButton.click();

                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
                WebElement loadersMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
                wait.until(ExpectedConditions.invisibilityOf(loadersMask));

                String actualFullName = dashboardPage.fullName.getText();

                XSSFCell resultCell = sheet.getRow(i).getCell(4);
                if (actualFullName.contains(firstName) && actualFullName.contains(lastName)){
                    System.out.println("PASS");
                    resultCell.setCellValue("PASS");
                }else{
                    System.out.println("FAIL");
                    resultCell.setCellValue("FAIL");
                }

                // logout
                dashboardPage.fullName.click();
                dashboardPage.logoutLink.click();


            }
                FileOutputStream out = new FileOutputStream(filePath);
                workbook.write(out);

                in.close();
                out.close();
                workbook.close();


        }
}
