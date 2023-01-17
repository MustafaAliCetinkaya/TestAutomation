package com.cydeo.reviewSessions;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupWorkAmazon extends TestBase {

    @Test
    public void amazon_test(){
        driver.get(ConfigurationReader.getProperty("amazon"));
        String expectedTitle ="Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sortButton= driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
        sortButton.click();

        WebElement lowToHigh = driver.findElement(By.xpath("//*[.='Price: Low to High']"));
        lowToHigh.click();
        WebElement nutella = driver.findElement(By.xpath("//span[contains(text(),'Nutella B-ready (44g (Pack of 3))')]"));
        nutella.click();

        WebElement addToCard= driver.findElement(By.cssSelector("input#add-to-cart-button"));
        addToCard.click();

        WebElement cart = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 nav-progressive-attribute']"));
        cart.click();

        Select quantity = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        quantity.selectByValue("5");

        WebElement checkout = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
        checkout.click();
    }

}
