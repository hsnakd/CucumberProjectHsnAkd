package com.cydeo.step_definitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class LocalizationTest {
    WebDriver driver;

    @Test
    public void localization_test1() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=zh-cn");
        driver=new ChromeDriver(options);
        driver.get("http://google.com");

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void localization_test2() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=da");
        driver=new ChromeDriver(options);
        driver.get("http://google.com");

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void localization_test3() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=fr-fr");
        driver=new ChromeDriver(options);
        driver.get("http://google.com");

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void localization_test4() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=hi");
        driver=new ChromeDriver(options);
        driver.get("http://google.com");

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void localization_test5() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=ja");
        driver=new ChromeDriver(options);
        driver.get("http://google.com");

        Thread.sleep(5000);
        driver.quit();
    }
//
//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//
//        //ChromeOptions object
//        ChromeOptions opt = new ChromeOptions();
//        //set language to Spanish
//        opt.addArguments("−−lang=es");
//        // configure options parameter to Chrome driver
//        WebDriver driver = new ChromeDriver(opt);
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        driver.get("https://www.google.com/ ");
//
//    }


    @Test
    public void localization_test7() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en-us");
        options.setExperimentalOption("prefs", prefs);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        System.out.println("Title in ES :"+driver.getTitle());

    }

}
