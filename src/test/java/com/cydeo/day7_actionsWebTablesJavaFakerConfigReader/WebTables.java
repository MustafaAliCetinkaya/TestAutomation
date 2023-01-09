package com.cydeo.day7_actionsWebTablesJavaFakerConfigReader;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void webTablesTest(){

        driver.get("https://practice.cydeo.com/tables");//When we sort the table, everything is reordered in it.

        WebElement tableHeaderFirstName= driver.findElement(By.xpath("//span[.='First Name']"));
        for (int i = 0; i <= 3; i++) {
            tableHeaderFirstName.click();
            System.out.println(driver.findElement(By.xpath("//td[contains(text(),'Jason')]")).getText());//Dynamic
        }

        List<WebElement>allRowThreeCells=driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td"));//NOT dynamic
        for (WebElement eachCell : allRowThreeCells) {
            System.out.println(eachCell.getText());
        }
    }
}
/* TODO - How do you handle dynamic web elements?
        - How do you handle web elements with dynamic attribute value?
        - Dynamic attribute value: means some part of an attribute value is changing when the page is refreshed.
    Answer#1:
    We use xpath methods: contains, starts-with, and ends-with
    We locate the part of the attribute that is not dynamic, and use that part within the xpath locators to locate the web element.
    Answer#2:
    We can also locate a static (stable) parent or child web element, locate that, and move to the desired web element.*/
