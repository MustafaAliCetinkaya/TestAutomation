package com.cydeo.reusableMethods.base;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static WebDriver driver;
    public static Actions actions;
    public static Faker faker;

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        faker = new Faker();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}
