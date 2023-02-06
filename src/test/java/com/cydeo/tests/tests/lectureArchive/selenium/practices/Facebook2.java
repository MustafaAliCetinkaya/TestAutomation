package com.cydeo.tests.tests.lectureArchive.selenium.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");


        // 3. Enter incorrect username
        WebElement incorrectUsername = driver.findElement(By.id("email"));
        incorrectUsername.sendKeys("dfagd@gmail.com");

        // 4. Enter incorrect password
        WebElement incorrectPassword = driver.findElement(By.id("pass"));
        incorrectPassword.sendKeys("32dfjgk");

        // 5. Verify title changed to:
        // Expected: “Log into Facebook"

        String expectedInTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedInTitle)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        driver.quit();
    }
}


