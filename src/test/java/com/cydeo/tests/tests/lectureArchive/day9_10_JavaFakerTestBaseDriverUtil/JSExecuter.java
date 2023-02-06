package com.cydeo.tests.tests.lectureArchive.day9_10_JavaFakerTestBaseDriverUtil;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
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

        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true);",cydeoLink);
        ReusableMethods.waitFor(2);

        js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()",cydeoLink);
        ReusableMethods.waitFor(4);


    }
}
