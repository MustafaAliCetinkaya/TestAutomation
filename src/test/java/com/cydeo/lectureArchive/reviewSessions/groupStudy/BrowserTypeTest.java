package com.cydeo.lectureArchive.reviewSessions.groupStudy;

import com.cydeo.utilities.miscellaneous.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserTypeTest{

    @Test
    public static void browserTypeTest(){
        WebDriver driver=BrowserFactory.getDriver("firefox");
        driver.get("https://www.google.com.tr/?hl=tr");
        String googleTitle=driver.getTitle();
        System.out.println(googleTitle);

        driver.get("https://etsy.com");
        String etsyTitle=driver.getTitle();
        System.out.println(etsyTitle);

        driver.navigate().back();
        verifyEquals(driver,googleTitle);

        driver.navigate().forward();
        verifyEquals(driver,etsyTitle);

        driver.quit();
    }

    public static void verifyEquals(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test is PASSED");
        }else{
            System.out.println("Test is FAILED");
        }
    }
}
