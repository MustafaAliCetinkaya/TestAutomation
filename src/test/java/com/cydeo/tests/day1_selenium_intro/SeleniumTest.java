package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //This line will maximize the browser size
        driver.manage().window().maximize();
        driver.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
        //Stop code execution for 3 seconds
        Thread.sleep(3000);
        /* this will close all of the opened windows by driver
        driver.quit();*/
        // this will close the currently opened window by driver
        driver.close();

     /*   WebDriverManager.safaridriver().setup();
        WebDriver safari=new SafariDriver();
        safari.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/0.htm");

        //This line will maximize the browser size
        safari.manage().window().maximize();*/

    }
}
