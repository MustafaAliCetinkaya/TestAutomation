package com.cydeo.selenium.day3_LocatorsFirstSixOnes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tasks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");

        System.out.println("--------------------------------------");

        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        WebElement headerText = driver.findElement(By.tagName("h3"));
        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header text verification PASSED!");
        } else {
            System.out.println("Header text verification FAILED!!!");
        }

        System.out.println("--------------------------------------");

        driver.navigate().to("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();
        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.equals(expectedGmailTitle))
            System.out.println("Title test passed");
        else
            System.out.println("Title test failed");

        driver.navigate().back();
        String expectedGoogleTitle = "Gmail";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.equals(expectedGoogleTitle))
            System.out.println("Google title test passed");
        else
            System.out.println("Google title test failed");

        System.out.println("--------------------------------------");

        driver.get("https://practice.cydeo.com/inputs");
        //driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.className("nav-link")).click();
        String expectedCydeoTitle = "Home";
        String actualCydeoTitle = driver.getTitle();

        if (actualCydeoTitle.equals(expectedCydeoTitle))
            System.out.println("Cydeo title test passed");
        else
            System.out.println("Cydeo title test failed");

        System.out.println("--------------------------------------");
        driver.get("https://tr-tr.facebook.com/");
        driver.manage().window().maximize();
        WebElement email=driver.findElement(By.id("name"));
        email.sendKeys("abc@gmail.com");



                driver.close();

    }

}
