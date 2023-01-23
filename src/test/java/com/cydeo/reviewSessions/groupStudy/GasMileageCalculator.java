package com.cydeo.reviewSessions.groupStudy;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculator extends TestBase {

    @Test
    public void gasMilAgeCalculator() {
        driver.get("https://www.calculator.net ");
        driver.findElement(By.id("calcSearchTerm")).sendKeys("gas mileage");
        driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Gas Mileage Calculator";
        Assert.assertEquals(actualTitle, expectedTitle, "Title test is failed");

        driver.findElement(By.xpath("//h1")).isDisplayed();

        Actions actions = new Actions(driver);

        WebElement odometer = Driver.getDriver().findElement(By.xpath("//input[@id='mucodreading']"));
        actions.click(odometer).keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys("7525")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys("7550")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys("16")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys("3.55")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement span = Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String actualResult = span.getText();
        String expectedResult = "(-3.68 mpg)";
        Assert.assertEquals(actualResult, expectedResult, "Calculation test is failed");

        /*odometer.clear();
        odometer.sendKeys("7925");

        WebElement podometer= Driver.getDriver().findElement(By.xpath("//input[@id='mupodreading']"));
        podometer.clear();
        podometer.sendKeys("7550");

        WebElement GasAdded= Driver.getDriver().findElement(By.xpath("//input[@id='mugasputin']"));
        GasAdded.clear();
        GasAdded.sendKeys("16");

        WebElement GasPrice= Driver.getDriver().findElement(By.xpath("//input[@id='mugasprice']"));
        GasPrice.clear();
        GasPrice.sendKeys("3.55");

        WebElement calculateButton= Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateButton.click();

        WebElement span= Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String actualResult= span.getText();
        String expectedResult="23.44 mpg";
        Assert.assertEquals(actualResult,expectedResult);*/

    }
}
