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
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl1"));
    }

    @When("user is on the second login page")
    public void user_is_on_the_second_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl2"));

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

    @When("user enters driver credentials")
    public void userEntersDriverCredentials() throws IOException {
        String path = "src/test/resources/source/VyTrackQa2Users.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("vyTrack1");
        String username = sheet.getRow(0).getCell(0).toString();
        String password = sheet.getRow(0).getCell(1).toString();
        loginPage.loginUsername.sendKeys(username);
        loginPage.loginPassword.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("user should see driver navigation options")
    public void userShouldSeeDriverNavigationOptions(List<String> menuOps) {
        List<String> actualOps = new ArrayList<>();
        for (WebElement menu : dashboardPage.menus) {
            actualOps.add(menu.getText());
        }
        Assert.assertEquals(menuOps,actualOps);
    }

    @When("user enters {string} information")
    public void userEntersInformation(String string) throws IOException {
        String path = "src/test/resources/source/VyTrackQa2Users.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("vyTrack1");
        String username = "";
        String password = "";


        switch (string){
            case "Sales":
                username = sheet.getRow(10).getCell(0).toString();
                password = sheet.getRow(10).getCell(1).toString();
                break;

            case "Store":
                username = sheet.getRow(6).getCell(0).toString();
                password = sheet.getRow(6).getCell(1).toString();
                break;
        }

        loginPage.loginUsername.sendKeys(username);
        loginPage.loginPassword.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("user should see manager navigation options")
    public void userShouldSeeManagerNavigationOptions(List<String> menuOps) {
        List<String> actualOps = new ArrayList<>();
        for (WebElement menu : dashboardPage.menus) {
            actualOps.add(menu.getText());
        }
        Assert.assertEquals(menuOps,actualOps);
    }


}


