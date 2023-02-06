package com.cydeo.lectureArchive.testNG.practices.tests;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestingTestBase extends TestBase {

    @Test(priority =5)
    public void test1() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h2")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("div"));
        System.out.println("AllIdentities.size() = " + AllIdentities.size());
        int count = 1;
        for (WebElement each : AllIdentities) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }

    @Test(priority =4)
    public void test2() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h2")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("div"));
        System.out.println("AllIdentities.size() = " + AllIdentities.size());
        int count = 1;
        for (WebElement each : AllIdentities) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }

    @Test(priority =3)
    public void test3() {
        driver.get("https://www.selenium.dev");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h2")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("div"));
        System.out.println("AllIdentities.size() = " + AllIdentities.size());
        int count = 1;
        for (WebElement each : AllIdentities) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }

    @Test(priority =2)
    public void test4() {
        driver.get("https://testng.org/doc/");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h2")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("div"));
        System.out.println("AllIdentities.size() = " + AllIdentities.size());
        int count = 1;
        for (WebElement each : AllIdentities) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }

    @Test (priority =1)
    public void test5() {
        driver.get("http://practice.cydeo.com/radio_buttons");
        System.out.println(driver.getTitle() + " : " +
                driver.getCurrentUrl() + "\n Page Headers: " +
                driver.findElements(By.tagName("h2")));

        List<WebElement> AllIdentities = driver.findElements(By.tagName("div"));
        System.out.println("AllIdentities.size() = " + AllIdentities.size());
        int count = 1;
        for (WebElement each : AllIdentities) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }
}
