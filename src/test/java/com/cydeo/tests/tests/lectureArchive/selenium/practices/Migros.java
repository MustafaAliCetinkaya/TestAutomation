package com.cydeo.tests.tests.lectureArchive.selenium.practices;

import com.cydeo.utilities.miscellaneous.ReusableMethods;
import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.miscellaneous.WebDriverFactory;
import org.openqa.selenium.*;

public class Migros extends TestBase {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(1);
        //Go to the market site
        driver.get("https://www.migros.com.tr/");
        //Accept cookies
        driver.findElement(By.xpath("//button[.='Tümünü Kabul Et']")).click();

        //Find the search box and search for kek
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='product-search-combobox--trigger']"));
        searchBox.sendKeys("kek" + Keys.ENTER);

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

        driver.findElement(By.xpath("//label[@for=\"mat-mdc-checkbox-29-input\"]")).click();//Find the Dankek brands group.

        driver.findElement(By.xpath("//fa-icon[@id='product-actions-add-to-cart-button--dankek-mozaik-baton-kek-200-g-p-6b14e7']")).click();//Add first item on the list


        //Go to cart
        driver.findElement(By.cssSelector("#homepage-cart-button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//Button[.='Sepete Git']")));
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//button[@aria-label=\"Sepetteki ürün sayısını arttır\"])[1]")));


        //Go to payment page
        WebElement continueButton = driver.findElement(By.cssSelector("button#checkout-summary-desktop-confirm-button"));
        ReusableMethods.waitForClickablility(continueButton, 50);
        continueButton.click();
        driver.findElement(By.cssSelector("button.subtitle-2.text-color-grey.continue-without-register.mdc-button.mat-mdc-button.mat-unthemed.mat-mdc-button-base")).click();


        //Enter your personal information
        driver.findElement(By.cssSelector("#mat-input-1")).sendKeys("Mustafa Ali");
        driver.findElement(By.cssSelector("#mat-input-2")).sendKeys("Çetinkaya");
        driver.findElement(By.cssSelector("#mat-input-3")).sendKeys("I signed the task. Enough for practice!");

        System.out.println("We are done without any error!");
    }
}
