package com.cydeo.testNG;

import com.cydeo.selenium.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class TestNG_Intro {
    WebDriver driver= WebDriverFactory.getDriver("chrome");

    @Test (priority = 1)
    public void test1(){
        System.out.println("Test 1 is running...");

        //ASSERT EQUALS: compare 2 of the same things
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual, expected);//This is hard assertion. If the previous test is failed, remaining code will not be executed in the block.


        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google","Title test1 passed");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        //AssertTrue
        String actual = "apple";
        String expected = "apple";
        Assert.assertTrue(actual.equals(expected), "your message will go here");


        driver.navigate().to("https://cydeo.com");
        String expectedTitle="Cydeo";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle),"Title test2 passed");
        driver.quit();
    }

    @BeforeClass
    public void setupMethod(){
        System.out.println("-----> BeforeClass is running!");

    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----> AfterClass is running!");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
    }
}