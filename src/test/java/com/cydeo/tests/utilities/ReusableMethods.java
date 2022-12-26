package com.cydeo.tests.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
    //====== js ======//
    public static void jsClick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver("chrome");
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver("chrome");
            executor.executeScript("arguments[0].click();", webElement);
        }

    }
}
