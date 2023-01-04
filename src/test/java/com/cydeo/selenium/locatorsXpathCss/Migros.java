package com.cydeo.selenium.locatorsXpathCss;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Migros {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        //Go to the market site
        driver.get("https://www.migros.com.tr/");
        //Accept cookies
        driver.findElement(By.xpath("//button[.='Tümünü Kabul Et']")).click();

        //Find the search box and search for kek
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='product-search-combobox--trigger']"));
        searchBox.sendKeys("kek" + Keys.ENTER);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//Wait for uploading
        //First item will be added after clicking the mandatory fields
        //First things first, fill the related checkboxes
        WebElement firstItem = driver.findElement(By.xpath("//div[@class='bottom-row']//fa-icon[@id='product-actions-add-to-cart-button--kekstra-konfeti-muffin-kek-kakaolu-38-g-p-4dad0d']"));
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//Wait for uploading
        firstItem.click();
        driver.findElement(By.xpath("//div[.='Tıkla Gel Al']")).click();
        driver.findElement(By.xpath("//span[.='İl']")).click();
        driver.findElement(By.xpath("//span[.=' Ankara ']")).click();
        driver.findElement(By.xpath("//span[.='İlçe']")).click();
        driver.findElement(By.xpath("//span[.=' Yenimahalle ']")).click();
        driver.findElement(By.xpath("//span[.='Mağaza']")).click();
        driver.findElement(By.xpath("//span[.=' ARMADA ']")).click();
        //Find the Dr.Oetker brands group. Add the first item and then select the number of items
        driver.findElement(By.xpath("//label[@for=\"mat-mdc-checkbox-29-input\"]")).click();//Find the Dr.Oetker brands group.


        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--8-kek-cilekli-55-g-p-4dad17']")).click();//Add first item on the list
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--8-kek-cikolatali-55-g-p-4dcd21']")).click();//Add first item on the list
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--8-kek-muzlu-55-g-p-4dc46d']")).click();//Add first item on the list
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--8-kek-findikli-52-g-p-6b1d0a']")).click();//Add first item on the list
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--dankek-meyveli-baton-kek-200-g-p-6b14e8']")).click();//Add first item on the list
        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--dankek-mozaik-baton-kek-200-g-p-6b14e7']")).click();//Add first item on the list


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
        driver.close();
    }
}
