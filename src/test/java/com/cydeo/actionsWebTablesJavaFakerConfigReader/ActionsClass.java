package com.cydeo.actionsWebTablesJavaFakerConfigReader;

import com.cydeo.reusableMethods.base.TestBase;
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
        System.out.println("Text of the big circle is: " + bigCircle.getText());
        Assert.assertEquals(bigCircle.getText(), "You did great!");

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

        action.moveToElement(smallCircle).clickAndHold().pause(1000).perform();
        System.out.println("When we click on the small circle, 'Blue' text is: " + blueSquare.getText());
        System.out.println("When we click on the small circle, 'Orange' text is: " + orangeSquare.getText());
        Assert.assertEquals(blueSquare.getText(), "(Drop here)");
        Assert.assertEquals(orangeSquare.getText(), "(Drop here)");

        action.moveToElement(smallCircle).clickAndHold()
                .pause(1000).moveToElement(blueSquare)
                .pause(1000).perform();
        System.out.println("When we hover over the 'Blue', 'Blue' text is: " + blueSquare.getText());
        System.out.println("When we hover over the 'Blue', 'Orange' text is: " + orangeSquare.getText());
        Assert.assertEquals(blueSquare.getText(), "Now you can drop it.");
        Assert.assertEquals(orangeSquare.getText(), "(Drop here)");


    }
}
