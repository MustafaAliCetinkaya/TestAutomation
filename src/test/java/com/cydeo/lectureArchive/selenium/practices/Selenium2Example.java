package com.cydeo.lectureArchive.selenium.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium2Example {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

        // An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time
        // when trying to find an element or elements if they are not immediately available.
        // The default setting is 0. Once set, the implicit wait is set for the life of the WebDriver object instance.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize the browser window to fit into screen
        driver.manage().window().maximize();

        // Visit Google
        driver.get("https://www.google.com");

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Selenium!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        driver.findElement(By.xpath("//h3[.='Selenium']")).click();

        System.out.println("Page title is: " + driver.getTitle());

        System.out.println("Page header is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());
        //System.out.println("Page motto is: " + driver.findElement(By.xpath("//p[.='What you do with that power is entirely up to you.']")).getText());
        WebElement motto = driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/p"));
        System.out.printf("Page motto is: ", motto.getText());
        //Verify header text is as expected:
        WebElement headerText = driver.findElement(By.tagName("h1"));
        String expectedHeaderText = "Selenium automates browsers. That's it!";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Selenium header text verification PASSED!");
        } else {
            System.out.println("Selenium header  verification FAILED!!!");
        }

        //Close the browser
        driver.quit();
    }
}
