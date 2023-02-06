package com.cydeo.tests.tests.lectureArchive.selenium.practices;

import com.cydeo.utilities.miscellaneous.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        //Go to: Amazon site
        driver.get("https://www.amazon.com");
        //Find the search box
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        //Search for item
        searchBox.sendKeys("game chairs"+ Keys.ENTER);
        //Sort by price//a[.='Featured']
        driver.findElement(By.xpath("//span[.='Sort by:']")).click();
        //driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();  Another way for sorting
        //driver.findElement(By.xpath("//a[.='Price: Low to High']")).click();Another way for sorting
        driver.findElement(By.cssSelector("a[id='s-result-sort-select_1']")).click();

        //First item
        driver.findElement(By.cssSelector("img[alt='FranFusion Inflatable Gaming Chair for Kids & Teens with Cup Holder and Side Pocket - Video Game Chairs, Perfect Room Deco...']")).click();
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();

        //Second item
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("game chairs"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[.='Sort by:']")).click();
        driver.findElement(By.xpath("//a[.='Price: Low to High']")).click();
        driver.findElement(By.cssSelector("img[alt='Office Gaming Chair with Flip-up Armrests, Ergonomic Computer Game Chair Bonded Leather Swivel Desk Chair Adjustable Heigh...']")).click();
        //driver.findElement(By.cssSelector("img[data-image-index='13']")).click(); Always getting different item. Order of the items changes
        driver.findElement(By.xpath("//span[@id='a-autoid-4-announce']")).click();
        driver.findElement(By.xpath("//a[@id='quantity_2']")).click();
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();

        //Go to the cart
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        //Search for third item and add it
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook air m1 mouse wireless"+Keys.ENTER);
        driver.findElement(By.xpath("//*[.='Featured']")).click();
        driver.findElement(By.xpath("//*[.='Price: Low to High']")).click();
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        driver.findElement(By.xpath("(//span[.='Add to Cart']//span)[1]")).click();

        //Go to cart for paying
        driver.findElement(By.xpath("//a[@ href=\"/gp/cart/view.html?ref_=sw_gtc\"]")).click();
        driver.findElement(By.cssSelector("input#sc-buy-box-gift-checkbox")).click();//Click the gift button
        driver.findElement(By.xpath("//input[@name=\"proceedToRetailCheckout\"]")).click();//Proceed to check out
        driver.findElement(By.cssSelector("input#ap_email")).sendKeys("We are done! Enough for practice.");//Login page

        //driver.close();
    }
}
