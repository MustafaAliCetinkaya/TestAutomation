package com.cydeo.selenium.seleniumIntro;

import com.cydeo.selenium.practices.SeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingTitlePage extends SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/0.htm");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        String pageTitle = driver.getTitle();

        if (pageTitle.equals("Welcome to Discovering Geometry"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");


        driver.get("https://www.tesla.com");
        //get the title of the page
        Thread.sleep(2000);
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        driver.close();
    }
}
