package com.cydeo.tests.tests.lectureArchive.day7_actionsWebTablesConfigReader;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsHoverOver extends TestBase {
    @Test
    public void hoverTest() {

        driver.get("http://practice.cydeo.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img1Text = driver.findElement(By.xpath("//h5[.='name: user1']"));
        WebElement img1LinkText = driver.findElement(By.xpath("(//a)[2]"));

        Actions action = new Actions(driver);

        action.moveToElement(img1).pause(2000).perform();
        Assert.assertTrue(img1Text.isDisplayed());
        Assert.assertTrue(img1LinkText.isDisplayed());
        System.out.println("Text of image-1 when we hover over it is: " + img1Text.getText());
        System.out.println("Link text of the image-1 when we hover over it is: " + img1LinkText.getText());

        Assert.assertEquals(driver.findElement(By.xpath("//h5[.='name: user1']")).getText(), "name: user1");
    }

    @Test
    public void hoverTest2() {

        driver.get("http://practice.cydeo.com/hovers");

        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        int count = 1;
        for (WebElement eachImage : allImages) {
            Actions action = new Actions(driver);
            action.moveToElement(eachImage).pause(2000).perform();
            System.out.println(count+". picture is hover overed.");
            count++;
        }
    }
}
