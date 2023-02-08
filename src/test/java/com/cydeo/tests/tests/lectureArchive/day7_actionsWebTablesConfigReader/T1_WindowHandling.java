package com.cydeo.tests.tests.lectureArchive.day7_actionsWebTablesConfigReader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_WindowHandling extends TestBase {

    @Test
    public void window_handling_test(){
        //2. Go to: https://www.amazon.com
        driver.get(ConfigurationReader.getProperty("amazon"));//Reusable, dynamic
        ReusableMethods.switchToWindows(driver);

        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        BrowserUtilities.switchWindowAndVerify( "etsy", "Etsy");


    }
}
