package com.cydeo.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShoppingCart2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.gimatsepeti.com/");
        driver.findElement(By.xpath("//button[.='tamam']")).click();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("sucuk" + Keys.ENTER);

        WebElement addLink = driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/button"));
        for (int i = 0; i < 100; i++) {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", addLink);
        }

        driver.findElement(By.linkText("alışveriş sepetinize")).click();
        driver.close();
    }
}
