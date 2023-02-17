package com.cydeo.tests.tests.lectureArchive.testNG.practices.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingColorOfWebElements {
    @Test
    public void checkOrVerifyColorOfWebElements() {
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));

        WebElement element = Driver.getDriver().findElement(By.id("nav-cart-count"));
        System.out.println("element.getCssValue(\"color\") = " + element.getCssValue("color"));
        System.out.println("element.getCssValue(\"position\") = " + element.getCssValue("position"));
        System.out.println("element.getCssValue(\"display\") = " + element.getCssValue("display"));
        System.out.println("element.getCssValue(\"line-height\") = " + element.getCssValue("line-height"));

        //Getting/Asserting Hex format of colors

        WebElement button=Driver.getDriver().findElement(By.cssSelector("a.a-button-text"));
        String buttonColor= button.getCssValue("color");
        String hexFormatOfButtonColor= Color.fromString(buttonColor).asHex();
        System.out.println(hexFormatOfButtonColor);

        Assert.assertEquals("#0f1111",hexFormatOfButtonColor);

        Driver.closeDriver();
    }
}
