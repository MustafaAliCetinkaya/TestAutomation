package com.cydeo.tests.locatorsXpathCss;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GimatGross {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to the market site
        driver.navigate().to("https://www.gimatsepeti.com/");
        //Accept cookies
        driver.findElement(By.cssSelector("button[id='eu-cookie-ok']")).click();

        //Find the search box and search for kaymak
        WebElement searchBox = driver.findElement(By.cssSelector("input#small-searchterms"));
        searchBox.sendKeys("kaymak" + Keys.ENTER);

        //First item is added
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='5546']")).sendKeys(Keys.BACK_SPACE+"5");
        driver.findElement(By.cssSelector("div[data-productid='5546']>div>div>div>button")).click();

        //Second item is added
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.cssSelector("div[data-productid='3034']>div>div>div>div>span[class='artir']")).click();
        }

        driver.findElement(By.cssSelector("div[data-productid='3034']>div>div>div>button")).click();

        // item is added
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.cssSelector("div[data-productid='15865']>div>div>div>div>span[class='artir']")).click();
        }
        driver.findElement(By.cssSelector("div[data-productid='15865']>div>div>div>button")).click();

        //Go to the cart
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href='/cart']")).click();

        //Write a shopping note
        driver.findElement(By.cssSelector("#checkout_attribute_10")).sendKeys("Great shopping. Thanks");

        //Click the mandatory fields
        driver.findElement(By.cssSelector("label[for='checkout_attribute_6_28']")).click();
        driver.findElement(By.cssSelector("label[for='termsofservice']")).click();
        driver.close();
    }
}
