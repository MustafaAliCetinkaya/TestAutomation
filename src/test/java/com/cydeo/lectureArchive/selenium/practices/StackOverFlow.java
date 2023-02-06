package com.cydeo.lectureArchive.selenium.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StackOverFlow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to the main page
        driver.get("https://stackoverflow.com");
        //Accept the cookies
        driver.findElement(By.xpath("(//button)[3]")).click();
        //Go to the Questions link (At the footer)
        WebElement element=driver.findElement(By.xpath("(//a[@href='/questions'])[6]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        //Add the all question links to the ArrayList
        List<WebElement> list = driver.findElements(By.className("question-hyperlink"));

        System.out.println("Number of the current top questions: " + list.size());

        int count = 1;
        for (WebElement each : list) {
            if(!each.getText().equals(""))
            System.out.println(count + ". Top question link title is : " + each.getText());
            else
                System.out.println(count + ". Top question link title is not assigned");
            count++;
            System.out.println("----------------------------------");
        }
        driver.close();
    }
}
