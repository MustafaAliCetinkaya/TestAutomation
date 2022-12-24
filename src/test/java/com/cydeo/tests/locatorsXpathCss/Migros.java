package com.cydeo.tests.locatorsXpathCss;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Migros {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Go to the market site
        driver.get("https://www.migros.com.tr/");
        //Accept cookies
        driver.findElement(By.xpath("//button[.='Tümünü Kabul Et']")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//Wait for uploading


        //Find the search box and search for kek
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='product-search-combobox--trigger']"));
        searchBox.sendKeys("kek" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//Wait for uploading
        //First item will be added after clicking the mandatory fields
        //First things first, fill the related checkboxes
        WebElement firstItem = driver.findElement(By.xpath("//div[@class='bottom-row']//fa-icon[@id='product-actions-add-to-cart-button--kekstra-konfeti-muffin-kek-kakaolu-38-g-p-4dad0d']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//Wait for uploading
        firstItem.click();
        driver.findElement(By.xpath("//div[.='Tıkla Gel Al']")).click();
        driver.findElement(By.xpath("//span[.='İl']")).click();
        driver.findElement(By.xpath("//span[.=' Ankara ']")).click();
        driver.findElement(By.xpath("//span[.='İlçe']")).click();
        driver.findElement(By.xpath("//span[.=' Yenimahalle ']")).click();
        driver.findElement(By.xpath("//span[.='Mağaza']")).click();
        driver.findElement(By.xpath("//span[.=' ARMADA ']")).click();
        //Find the Dr.Oetker brands group. Add the first item and then select the number of items
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//Wait for uploading
        driver.findElement(By.xpath("//input[@id='mat-mdc-checkbox-32-input']")).click();//Find the Dr.Oetker brands group.
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//Wait for uploading
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--droetker-limonlu-kek-karisimi-440-g-p-4cebd2']")).click();//Add first item on the list

        for (int i = 0; i < 24; i++) {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//Wait for uploading
            driver.findElement(By.cssSelector("#product-actions-product-increase--droetker-limonlu-kek-karisimi-440-g-p-4cebd2")).click();
        }

        //Go to cart
        driver.findElement(By.cssSelector("#homepage-cart-button")).click();
        driver.findElement(By.xpath("//Button[.='Sepete Git']")).click();

        //Go to payment page
        driver.findElement(By.cssSelector("#checkout-summary-desktop-confirm-button")).click();
        driver.findElement(By.xpath("//span[.=' Üye olmadan devam et ']")).click();

        //Enter your personal information
        driver.findElement(By.cssSelector("#mat-input-1")).sendKeys("Mustafa Ali");
        driver.findElement(By.cssSelector("#mat-input-2")).sendKeys("Çetinkaya");
        driver.findElement(By.cssSelector("#mat-input-3")).sendKeys("I signed the task. Enough for practice!");

        System.out.println("We are done without any error!");
        //driver.close();
    }
}
