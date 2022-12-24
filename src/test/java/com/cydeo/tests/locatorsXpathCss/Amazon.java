package com.cydeo.tests.locatorsXpathCss;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Go to: Amazon site
        driver.get("https://www.amazon.com");
        //Find the search box
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        //Search for item
        searchBox.sendKeys("game chairs"+ Keys.ENTER);
        //Sort by price//a[.='Featured']
        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();
        driver.findElement(By.xpath("//a[.='Price: Low to High']")).click();

        driver.findElement(By.xpath("(//img[@class='s-image'])[10]")).click();

    }
}
