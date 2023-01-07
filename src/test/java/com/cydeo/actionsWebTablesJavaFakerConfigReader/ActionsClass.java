package com.cydeo.actionsWebTablesJavaFakerConfigReader;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass extends TestBase {

    @Test
    public void DragAndDropTest(){
        driver.get("https://demos.telerik.com/aspnet-ajax/dragdropmanager/overview/defaultcs.aspx");
        WebElement smallCircle= driver.findElement(By.id("draggable"));
        WebElement biglCircle= driver.findElement(By.id("ctl00_ContentPlaceholder1_droptarget"));

        Actions actions=new Actions(driver);

        /*The best and fast way:
        actions.dragAndDrop(smallCircle,biglCircle).perform();
        Assert.assertEquals(biglCircle.getText(),"You did great!");
        */

        //Second Way: Too long and detailed manually
        actions.moveToElement(smallCircle).pause(1000)
                .clickAndHold(smallCircle).pause(1000)
                .moveToElement(biglCircle).pause(1000)
                .release().perform();

        Assert.assertEquals(biglCircle.getText(),"You did great!");

    }
}
