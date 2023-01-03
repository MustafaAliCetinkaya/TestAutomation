package com.cydeo.testNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    WebDriver driver;

    @Test(dataProvider = "searchData")
    public void test(String keyword, String expectedUrl) {
        driver = WebDriverFactory.getDriver(1);
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword + Keys.ENTER);

        driver.findElement(By.xpath("(//*[contains(text(),\"https://\")])[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,keyword+" test is failed");

        driver.close();
    }

    @DataProvider(name = "searchData")
    public Object[][] testData() {
        return new Object[][]{
                {"cydeo","https://cydeo.com"} ,
                {"java","https://www.java.com"} ,
                {"selenium","https://www.selenium.com"} ,
                {"testNG","https://www.testng.com"} ,
                {"migros","https://www.migros.com.tr"} ,
                {"amazon","https://www.amazon.com"}
        };
    }
}
