package com.cydeo.tests.seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) {
        //TC #1: Facebook title verification

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Facebook Title verification PASSED!");
        }else{
            System.out.println("Facebook Title verification FAILED!!!");
        }
        driver.close();
    }
}
