package com.cydeo.selenium.seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoAttack {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cydeo.com");

        for (int i = 0; i < 100; i++) {
            WebElement programs= driver.findElement(By.linkText("Programs"));
            Thread.sleep(2000);
            programs.click();
            WebElement about= driver.findElement(By.linkText("About"));
            Thread.sleep(2000);
            about.click();
            WebElement careers= driver.findElement(By.linkText("Careers"));
            Thread.sleep(2000);
            careers.click();
            WebElement partnerships= driver.findElement(By.linkText("Partnerships"));
            Thread.sleep(2000);
            partnerships.click();
            WebElement apply= driver.findElement(By.linkText("Apply Now"));
            Thread.sleep(2000);
            apply.click();
            WebElement name= driver.findElement(By.cssSelector("#input_2_2"));
            name.sendKeys("Kuzzat");
            WebElement Surname= driver.findElement(By.cssSelector("#input_2_3"));
            Surname.sendKeys("Altay");
            WebElement MiddleName= driver.findElement(By.cssSelector("#input_2_16"));
            MiddleName.sendKeys("Emperor");
            WebElement PreferredName= driver.findElement(By.cssSelector("#input_2_28"));
            PreferredName.sendKeys("One of us / Enough for practice");

        }
        driver.quit();
    }
}
