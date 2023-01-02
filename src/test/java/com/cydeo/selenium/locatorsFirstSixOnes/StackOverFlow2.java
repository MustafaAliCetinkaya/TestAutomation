package com.cydeo.selenium.locatorsFirstSixOnes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StackOverFlow2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com");

        WebElement questionsLink = driver.findElement(By.linkText("Questions"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", questionsLink);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int count = 1;
        for (WebElement element : allLinks) {
            System.out.println(count+". link on the page is: "+element.getText());
            count++;
        }
        driver.close();
    }
}
