package com.cydeo.tests.tests.lectureArchive.reviewSessions.officeHour;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlerts extends TestBase {


    // 1 . alert
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);
    }

    // 2. confirm alert
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
    }

    //3. prompt alert
    @Test
    public void test3() throws InterruptedException {
        String input = "EU10 office hour";
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.accept();

        String actual = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actual.contains(input));
        Thread.sleep(2000);
    }

}