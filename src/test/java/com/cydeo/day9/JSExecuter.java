package com.cydeo.day9;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuter extends TestBase {

    @Test
    public void scrollingDownTest() {
        driver.get(ConfigurationReader.getProperty("practice"));
        WebElement cydeoLink=driver.findElement(By.linkText("CYDEO"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",cydeoLink);

    }
}
