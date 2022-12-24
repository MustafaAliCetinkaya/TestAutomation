package com.cydeo.tests.locatorsFirstSixOnes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", addLink);
        }
        Thread.sleep(2000);
        WebElement akseker = driver.findElement(By.id("8939"));
        akseker.sendKeys(Keys.BACK_SPACE + "10" + Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/div[2]/div[3]/div[2]/div/span[1]")).click();
        Thread.sleep(2000);

        WebElement meram = driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/div[2]/div[3]/div[2]/button"));
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", meram);

        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[2]/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("alışveriş sepetinize")).click();

        //driver.close();
    }
}
