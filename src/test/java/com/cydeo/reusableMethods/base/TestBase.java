package com.cydeo.reusableMethods.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}
