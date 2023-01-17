package com.cydeo.day9_10_JavaFakerTestBaseDriverUtil;

import com.cydeo.reusableMethods.base.TestBaseBeforeClassAfterClass;
import com.cydeo.reusableMethods.methods.ReusableMethods;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ActionsAmazonHoverOver extends TestBaseBeforeClassAfterClass {

    @Test
    public void hoverTest() {
        driver.get(ConfigurationReader.getProperty("amazon"));

        WebElement singIn = driver.findElement(By.cssSelector("a.nav-a.nav-a-2.nav-progressive-attribute:nth-of-type(2)"));
        actions.moveToElement(singIn).pause(4000).perform();

        WebElement language = driver.findElement(By.cssSelector("a.nav-a.nav-a-2.icp-link-style-2"));
        actions.moveToElement(language).pause(4000).perform();

        for (int i = 0; i < 20; i++) {
            actions.sendKeys(Keys.DOWN).pause(1000).perform();
        }

     /*   for (int i = 0; i < 20; i++) {
            actions.sendKeys(Keys.ENTER).pause(1000).perform();
        }*/

        ((JavascriptExecutor)driver).executeScript("scroll(0,750)");
        ReusableMethods.waitFor(4);


        WebElement bottomLanguageButton= driver.findElement(By.cssSelector("a.icp-button:nth-of-type(1)"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",bottomLanguageButton);
        actions.moveToElement(bottomLanguageButton);
        ReusableMethods.waitFor(4);


    }
}
