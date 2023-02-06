package com.cydeo.lectureArchive.day7_actionsWebTablesConfigReader;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C02_WebTables extends TestBase {

    @Test
    public void test1() {

        //Bir önceki class'daki adrese gidelim
        //girişYap methodunu kullanarak sayfaya giriş yapalım
        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım

        int satir = 4;
        int sutun = 4;
        login();



        WebElement arananCell =
                driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());


    }

    public void login() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

        Actions actions = new Actions(driver);

        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
        /*
        Diğer yöntem
        //○ Username : manager
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        //○ Password : Manager1!
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!", Keys.ENTER);
         */

    }

}