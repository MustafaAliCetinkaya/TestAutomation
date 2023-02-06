package com.cydeo.lectureArchive.testNG.day5;

import com.cydeo.tests.base.TestBaseBeforeClassAfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_DependsOnMethod extends TestBaseBeforeClassAfterClass {

    // (dependsOnMethods = Bu yontem, bir metodun diğer bir metoda bağlı olmasını sağlamak için kullanılır.

    @Test
    public void test1() {
        //amazon ana sayfasına gidelim
        driver.get("https://www.amazon.com");

    }

    @Test(dependsOnMethods = "test1" )
    public void test2() {

        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

    }

    @Test (dependsOnMethods = "test2")
    public void test3() {

        //Sonuc yazısının amazon içerdiğini test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));

        /*
         //sonuc yazisinin nutella icerdigini test edelim
           assert !driver.findElement(By.cssSelector("div[class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText().contains("amazon");
          }
         */

    }
}