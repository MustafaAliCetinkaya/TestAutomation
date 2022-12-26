package com.cydeo.tests.locatorsXpathCss;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Go to: Amazon site
        driver.get("https://www.amazon.com");
        //Find the search box
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        //Search for item
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchBox.sendKeys("game chairs"+ Keys.ENTER);
        //Sort by price//a[.='Featured']
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[.='Price: Low to High']")).click();
        //driver.findElement(By.cssSelector("a[id='s-result-sort-select_1']")).click(); Another way for locating below given element
        //First item
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("img[alt='Ninecer High Back Office Chair Ergonomic, Home Office Desk Chair for Teens 330 lbs, Comfortable Computer Gaming Chair Chea...']")).click();
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();
        //Second item
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("game chairs"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[.='Sort by:']")).click();
        driver.findElement(By.xpath("//a[.='Price: Low to High']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("img[alt='Office Gaming Chair with Flip-up Armrests, Ergonomic Computer Game Chair Bonded Leather Swivel Desk Chair Adjustable Heigh...']")).click();
        //driver.findElement(By.cssSelector("img[data-image-index='13']")).click(); Always getting different item. Order of the items changes
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@id='a-autoid-4-announce']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@id='quantity_2']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();

        //Go to the cart
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        //Search for second item and add it
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook air m1 mouse wireless"+Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[.='Featured']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[.='Price: Low to High']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();



    }
}
