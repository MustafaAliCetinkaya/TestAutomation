package com.cydeo.tests.tests.lectureArchive.day7_actionsWebTablesConfigReader;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass extends TestBase {

    @Test
    public void DragAndDropTest1() {
        driver.get("https://demos.telerik.com/aspnet-ajax/dragdropmanager/overview/defaultcs.aspx");
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("ctl00_ContentPlaceholder1_droptarget"));

        Actions actions = new Actions(driver);

        /*The best and fast way:
        actions.dragAndDrop(smallCircle,bigCircle).perform();
        Assert.assertEquals(bigCircle.getText(),"You did great!");
        */

        //Second Way: Too long and detailed manually
        actions.moveToElement(smallCircle).pause(1000)
                .clickAndHold().pause(1000)
                .moveToElement(bigCircle).pause(1000)
                .release().pause(1000).perform();
        System.out.println("Text of the big circle is: " + driver.findElement(By.id("ctl00_ContentPlaceholder1_droptarget")).getText());
        Assert.assertEquals(driver.findElement(By.id("ctl00_ContentPlaceholder1_droptarget")).getText(), "You did great!");

    }


    @Test
    public void DragAndDropTest2() {
        driver.get("https://demos.telerik.com/aspnet-ajax/dragdropmanager/area/defaultcs.aspx");

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement blueSquare = driver.findElement(By.cssSelector("div.test1"));
        WebElement orangeSquare = driver.findElement(By.cssSelector("div.test2"));
        WebElement title = driver.findElement(By.cssSelector("h1.kd-title"));

        System.out.println("Blue default text is: " + blueSquare.getText());
        System.out.println("Orange default text is: " + orangeSquare.getText());

        Assert.assertEquals(blueSquare.getText(), "Drag the small circle here ...");
        Assert.assertEquals(orangeSquare.getText(), "... Or here.");

        Actions action = new Actions(driver);

        action.moveToElement(smallCircle).clickAndHold()
                .pause(1000).moveToElement(title)
                .pause(3000).perform();
        System.out.println("When we click on the small circle and move it, 'Blue' text is: " + driver.findElement(By.cssSelector("div.test1")).getText());
        System.out.println("When we click on the small circle and move it, 'Orange' text is: " + driver.findElement(By.cssSelector("div.test2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.test1")).getText(), "(Drop here)");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.test2")).getText(), "(Drop here)");

        action.moveToElement(driver.findElement(By.id("draggable"))).clickAndHold()
                .pause(1000).moveToElement(driver.findElement(By.cssSelector("div.test1")))
                .pause(1000).release().perform();
        System.out.println("When we released the 'Blue', 'Blue' text is: " + driver.findElement(By.cssSelector("div.test1")).getText());
        System.out.println("When we released the 'Blue', 'Orange' text is: " + driver.findElement(By.cssSelector("div.test2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.test1")).getText(), "(Try again)");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.test2")).getText(), "(Try again)");


    }
}
