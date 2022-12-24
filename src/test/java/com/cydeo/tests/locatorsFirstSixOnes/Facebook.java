package com.cydeo.tests.locatorsFirstSixOnes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tr-tr.facebook.com/");

        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("abc@gmail.com");

        WebElement password=driver.findElement(By.id("pass"));
        password.sendKeys("12344556");

        WebElement signin=driver.findElement(By.name("login"));
        signin.click();




    }
}
