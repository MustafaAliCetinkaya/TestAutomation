package com.cydeo.lectureArchive.testNG.day5;

import com.cydeo.utilities.miscellaneous.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

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

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


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
        Assert.assertTrue(actual.equals(expected), "If the test is failed, this message will be thrown");//This is hard assertion. If the previous test is failed, remaining code will not be executed in the block.
//Messages are shown if the test is failed. Otherwise, we will not see this messages!
//Since it is a hard assertion, if the above written codes are not passed, below block will not be executed.
        driver.navigate().to("https://cydeo.com");
        String expectedTitle="Cydeo";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle),"Title test2 passed");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
        driver.quit();
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----> AfterClass is running!");
    }
}

