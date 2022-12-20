package com.cydeo.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.gimatgross.net/");

        driver.findElement(By.linkText("Gimat Sepeti")).click();
        WebElement serachBox = driver.findElement(By.name("q"));
        serachBox.sendKeys("sucuk" + Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/button")).click();

    }
}
