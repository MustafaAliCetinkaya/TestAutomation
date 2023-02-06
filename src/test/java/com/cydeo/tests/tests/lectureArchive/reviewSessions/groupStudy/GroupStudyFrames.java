package com.cydeo.tests.tests.lectureArchive.reviewSessions.groupStudy;

import com.cydeo.tests.base.TestBaseBeforeClassAfterClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupStudyFrames extends TestBaseBeforeClassAfterClass {

    @Test
    public void frameTest() throws InterruptedException {
        driver.get("https://cydeo.com/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='bewebchat']")));
        driver.findElement(By.xpath("//img[@id='chat-image']")).click();

        //returning the main html page
        driver.switchTo().parentFrame();

        //switching the new iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='window-iframe']")));


        //Faker faker=new Faker();
        //locating the input box


        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='webchat__name']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='webchat__name']")).sendKeys("Muhtar");
        Thread.sleep(2000);

/*        driver.get(ConfigurationReader.getProperty("practice"));

        driver.findElement(By.xpath("//a[.='Frames']")).click();
        driver.findElement(By.xpath("//a[.='iFrame']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        WebElement element= driver.findElement(By.xpath("//p"));
        System.out.println(element.getText());
        System.out.println(element.getAttribute("p"));*/
    }
}
