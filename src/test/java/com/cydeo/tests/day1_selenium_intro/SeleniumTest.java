package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //This line will maximize the browser size
        driver.manage().window().maximize();
        driver.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");

     /*   WebDriverManager.safaridriver().setup();
        WebDriver safari=new SafariDriver();
        safari.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/0.htm");

        //This line will maximize the browser size
        safari.manage().window().maximize();*/

    }
}
