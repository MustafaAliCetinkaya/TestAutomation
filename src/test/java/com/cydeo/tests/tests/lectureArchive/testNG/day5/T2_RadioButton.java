package com.cydeo.tests.tests.lectureArchive.testNG.day5;

import com.cydeo.utilities.miscellaneous.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_RadioButton {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver(1);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        Thread.sleep(2000);
        hockeyRadioBtn.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyRadioBtn.isSelected()){

            System.out.println("Button is selected. Verification PASSED!");

        }else{
            System.out.println("Button is not selected. Verification FAILED!!!");
        }

        driver.close();
    }
}