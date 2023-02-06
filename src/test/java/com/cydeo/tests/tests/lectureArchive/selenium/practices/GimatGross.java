package com.cydeo.tests.tests.lectureArchive.selenium.practices;

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
        driver.manage().deleteAllCookies();
        //Go to the market site
        driver.navigate().to("https://www.gimatsepeti.com/");
        //Accept cookies
        driver.findElement(By.cssSelector("button[id='eu-cookie-ok']")).click();

        //Find the search box and search for kaymak
        WebElement searchBox = driver.findElement(By.cssSelector("input#small-searchterms"));
        searchBox.sendKeys("kaymak" + Keys.ENTER);

        //First item is added
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='5546']")).sendKeys(Keys.BACK_SPACE + "5");
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
        WebElement checkBox1 = driver.findElement(By.cssSelector("label[for='checkout_attribute_6_28']"));
        System.out.println("Before click checkBox1.isSelected()= " + checkBox1.isSelected());
        checkBox1.click();
        System.out.println("After click checkBox1.getAttribute()= " + checkBox1.getAttribute("label"));
        if (checkBox1.isSelected())
            System.out.println("CheckBox1 is already selected");
        else {
            System.out.println("CheckBox was not selected before. We did it just now!");
            checkBox1.click();
        }

        WebElement checkBox2 = driver.findElement(By.cssSelector("label[for='termsofservice']"));
        System.out.println("Before click checkBox1.getAttribute()= " + checkBox2.getAttribute("label"));
        checkBox2.click();
        System.out.println("After click checkBox1.isSelected()= " + checkBox2.isSelected());

        driver.close();
    }
}
