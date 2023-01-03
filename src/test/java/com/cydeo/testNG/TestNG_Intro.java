package com.cydeo.testNG;

import com.cydeo.selenium.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNG_Intro {
    @BeforeClass
    public void setupMethod(){
        System.out.println("-----> BeforeClass is running!");

        SoftAssert softAssert=new SoftAssert();//This is soft assertion. Even if the previous test is failed, remaining code will be executed in the block.
        softAssert.assertNotEquals(6,7);
        System.out.println("softAssert test1 is passed");
        softAssert.assertEquals(45,45);
        System.out.println("softAssert test2 is passed");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
    }
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
        Assert.assertTrue(actual.equals(expected), "your message will go here");//This is hard assertion. If the previous test is failed, remaining code will not be executed in the block.


        driver.navigate().to("https://cydeo.com");
        String expectedTitle="Cydeo";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle),"Title test2 passed");
        driver.quit();
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----> AfterClass is running!");
    }
}

