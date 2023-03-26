package com.cydeo.tests.tests.lectureArchive.reviewSessions.officeHour;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest2 extends TestBase {


    // hover over
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        Actions actions = new Actions(driver);
        WebElement hoverMenu = driver.findElement(By.id("sub-menu"));
        actions.moveToElement(hoverMenu).perform();
        driver.findElement(By.id("link1")).click();
        Thread.sleep(3000);
    }

    // double Click
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        Actions actions = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(3000);
    }

    @Test
    public void test3(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(sourceElement,targetElement).perform();
        Assert.assertEquals(targetElement.getText(),"You did great!");
    }

    // keyboard actions
    @Test
    public void test4(){
        driver.get("https://practice.cydeo.com/key_presses");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.SPACE).perform();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("SPACE"));

        String input = "Space";

        switch (input){
            case "space":
                actions.sendKeys(Keys.SPACE).perform();
                Assert.assertTrue(result.getText().contains("SPACE"));
                break;
            case "Enter":

        }
    }
}