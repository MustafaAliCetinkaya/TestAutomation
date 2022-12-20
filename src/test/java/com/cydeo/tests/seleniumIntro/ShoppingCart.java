package com.cydeo.tests.seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.a101.com.tr/");

        WebElement searchBox = driver.findElement(By.name("search_text"));
        searchBox.sendKeys("İkbal Cezerye Fındıklı");
        searchBox.sendKeys(Keys.ENTER);

        driver.close();
    }
}
