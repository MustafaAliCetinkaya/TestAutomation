package com.cydeo.testNG;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestingTestBase extends TestBase {

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h1")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("id"));
        for (WebElement each : AllIdentities) {
            int count = 1;
            String eachId = each.getAttribute("id");
            System.out.println(count + ". id is: " + eachId);
            count++;
        }
    }

    @Test
    public void test2() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h1")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("id"));
        for (WebElement each : AllIdentities) {
            int count = 1;
            String eachId = each.getAttribute("id");
            System.out.println(count + ". id is: " + eachId);
            count++;
        }
    }

    @Test
    public void test3() {
        driver.get("https://www.selenium.dev");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h1")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("id"));
        for (WebElement each : AllIdentities) {
            int count = 1;
            String eachId = each.getAttribute("id");
            System.out.println(count + ". id is: " + eachId);
            count++;
        }
    }

    @Test
    public void test4() {
        driver.get("https://testng.org/doc/");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h1")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("id"));
        for (WebElement each : AllIdentities) {
            int count = 1;
            String eachId = each.getAttribute("id");
            System.out.println(count + ". id is: " + eachId);
            count++;
        }
    }
}
