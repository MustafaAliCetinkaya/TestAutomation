package com.cydeo.selenium.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.gimatgross.net/");

        driver.findElement(By.linkText("Gimat Sepeti")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("sucuk" + Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("alışveriş sepetinize")));

        driver.findElement(By.linkText("alışveriş sepetinize")).click();

        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath("//b[.='+']")).click();

        }

        driver.findElement(By.xpath("//button[.='Sepeti Güncelle']")).click();
        driver.findElement(By.xpath("//button[.='tamam']")).click();

    }
}
