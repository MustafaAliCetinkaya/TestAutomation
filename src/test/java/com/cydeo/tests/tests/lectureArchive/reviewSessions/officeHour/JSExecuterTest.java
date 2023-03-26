package com.cydeo.tests.tests.lectureArchive.reviewSessions.officeHour;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuterTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearch = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",googleSearch);
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'Cydeo10')",input);
        Thread.sleep(2000);

    }
}