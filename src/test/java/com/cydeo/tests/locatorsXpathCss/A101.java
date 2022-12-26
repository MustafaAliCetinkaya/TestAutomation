package com.cydeo.tests.locatorsXpathCss;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class A101 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Go to: A101 page
        driver.get("https://www.a101.com.tr/");
        //Accept the cookies
        WebElement cookies = driver.findElement(By.xpath("//button[.='Kabul Et']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cookies);
        try {
            cookies.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookies);
        }
        //Find the first item
        driver.findElement(By.xpath("(//a[@title=\"GİYİM & AKSESUAR\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[data-value=\"1588\"]")).click();
        driver.findElement(By.cssSelector("a[data-value=\"1589\"]")).click();
        driver.findElement(By.xpath("//label[.='40-45']")).click();
        driver.findElement(By.xpath("//label[.='Erkek']")).click();
        driver.findElement(By.xpath("//label[.='SİYAH']")).click();


        //Find the search box
        WebElement searchBox = driver.findElement(By.xpath("(//input[@name=\"search_text\"])[1]"));
        //Search for item

    }
}
