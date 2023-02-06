package com.cydeo.utilities.miscellaneous;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ReusableMethods {

    public static void verifyPageTitle(WebDriver driver,String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");
    }

    public static void verifyPageUrl(WebDriver driver,String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl, "This is a failure message. URL is not matching!");
    }

    //========Switching Window=====//
    public static void switchToWindows(WebDriver driver){
        Set<String> AllHandles=driver.getWindowHandles();
        for (String eachHandle : AllHandles) {
            System.out.println("Each Handle = " + eachHandle);
            driver.switchTo().window(eachHandle);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }
    }

    //========Hover Over=====//
    public static void hover(WebDriver driver,WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void scrollDownToElement(WebElement element) {
        ReusableMethods.waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }


    public static void jsClick(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    //   HARD WAIT WITH THREAD.SLEEP
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void forceToClick(WebDriver driver,WebElement element){

        for (int i = 0; i <= 2; i++) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void waitForPageToLoad(WebDriver driver,long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void testAllLinksOnThePage(WebDriver driver) {
        List<String> allPages = new ArrayList<>();
        for (int i = 1; i < 50; i++) {//Firstly, inspect your site, set the breakpoint of "i" based on the number of "href tags" on the page
            //This loop finds all href tags and store their values in allPages list
            String eachAddress = driver.findElement(By.xpath("(//a[@href])[" + i + "]")).getAttribute("href");
            allPages.add(eachAddress);
        }


        for (String each : allPages) {//This loop opens each link on a new tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('" + each + "', '_blank');");
        }


        Set<String> AllHandles = driver.getWindowHandles();
        int count = 1;
        for (String eachHandle : AllHandles) {//This loop navigates each tab and get title/URL
            driver.switchTo().window(eachHandle);
            System.out.println(count + ". page title is : " + driver.getTitle() + "\n" +
                    count + ". link is: " + driver.getCurrentUrl());
            driver.switchTo().parentFrame();
            count++;
        }
    }

    public static String mockEmailAndPasswordFactory() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

        String temp="";
        Random random = new Random();

        while (temp.length() < 10) { // length of the random string.
            int index = random.nextInt(39);
            temp+=allowedChars.charAt(index);
        }

        return temp;

    }

}
