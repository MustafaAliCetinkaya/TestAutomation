package com.cydeo.testNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DataProvider {
    WebDriver driver;
    List<String> titleAndUrl;

    @Test(dataProvider = "searchData")
    public void test(String keyword) {
        driver = WebDriverFactory.getDriver(1);
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword + Keys.ENTER);
        driver.findElement(By.xpath("(//*[contains(text(),\"https://\")])[2]")).click();
        titleAndUrl.add(driver.getTitle()+" / "+driver.getCurrentUrl());
        driver.quit();
    }

    @org.testng.annotations.DataProvider(name = "searchData")
    public Object[][] testData() {
        return new Object[][]{
                {"cydeo"} ,
                {"java"} ,
                {"selenium"} ,
                {"testNG"} ,
                {"migros"} ,
                {"amazon"} ,
        };

    }
}
