package com.cydeo.tests.locatorsFirstSix;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StackOverFlow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stackoverflow.com/questions");
        List<WebElement> list = driver.findElements(By.className("question-hyperlink"));

        System.out.println("Number of the current top questions: " + list.size());

        int count = 1;
        for (WebElement element : list) {
            System.out.println(count + ". Top question link is : " + element.getAttribute("href"));
            count++;
            System.out.println("----------------------------------");
        }
        driver.close();
    }

}
