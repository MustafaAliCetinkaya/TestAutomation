package com.cydeo.tests.locatorsXpathCss;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class A101 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Go to: A101 page
        driver.get("https://www.a101.com.tr/");
        //Accept the cookies
        WebElement cookies = driver.findElement(By.xpath("//button[.='Kabul Et']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cookies);
        try {
            cookies.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookies);
        }
        //Find the first item
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a[@title=\"GİYİM & AKSESUAR\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[data-value=\"1588\"]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[data-value=\"1589\"]")).click();
        driver.findElement(By.xpath("//label[.='40-45']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("label[for=\"attributes_integration_colourSİYAH\"]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@title=\"Unisex Termal Bot Çorap Siyah\"]")).click();
        //Verify the color
        String expectedColor="Siyah";
        String actualColor= driver.findElement(By.xpath("(//div[@class='selected-variant-text']//span)[2]")).getText();
        if(expectedColor.equalsIgnoreCase(actualColor))
            System.out.println("Color test is PASSED!");
        else
            System.out.println("Color test is FAILED!");
        //Add the item to the cart
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[title=\"40-45\"]")).click();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector("i.icon-plus")).click();
        }

        //Verify the title of the item contains expected:
        //Expected: "Çorap Siyah"
        String expectedWordInItemTitle="Çorap Siyah";
        String actualItemTitle=driver.findElement(By.cssSelector("h1.product-name.js-name")).getText();
        if(actualItemTitle.contains(expectedWordInItemTitle))
            System.out.println("Item title test is PASSED!");
        else
            System.out.println("Item title test is FAILED!");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("i.icon-sepetekle")).click();
        //Go to cart
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a.go-to-shop")).click();


        //Find the search box
        WebElement searchBox = driver.findElement(By.xpath("(//input[@name=\"search_text\"])[1]"));
        searchBox.sendKeys("Albeni"+ Keys.ENTER);
        //Search for item

    }
}
