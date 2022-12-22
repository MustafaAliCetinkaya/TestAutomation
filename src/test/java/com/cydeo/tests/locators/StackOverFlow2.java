package com.cydeo.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StackOverFlow2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com");
        try {
            //WebElement element = driver.findElement(By.xpath("//a[.='Questions']"));
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Questions")));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println(driver.findElement(By.linkText("Questions")).getAttribute("href"));
            driver.findElement(By.linkText("Questions")).click();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }
}
