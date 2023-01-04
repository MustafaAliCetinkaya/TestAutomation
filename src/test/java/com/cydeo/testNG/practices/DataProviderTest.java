package com.cydeo.testNG.practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    WebDriver driver;
    int count=1;

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("---> BeforeMethod is running! "+count+". test is started to execute");
        driver = WebDriverFactory.getDriver(1);
        driver.get("https://www.google.com");
    }

    @Test(dataProvider = "searchData")
    public void test(String keyword, String expectedUrl) {

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword + Keys.ENTER);

        driver.findElement(By.xpath("(//*[contains(text(),\"https://\")])[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,keyword+" test is failed");

    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running! "+count+". test is finished!");
        count++;
        driver.quit();
    }

    @DataProvider(name = "searchData")
    public Object[][] testData() {
        return new Object[][]{
                {"cydeo","https://cydeo.com/"} ,
                {"java","https://www.java.com/tr/"} ,
                {"selenium","https://www.selenium.dev/"} ,
                {"testNG","https://www.testng.com"} ,
                {"migros","https://www.migros.com.tr/"} ,
                {"amazon","https://www.amazon.com"}
        };
    }
}
