package com.cydeo.testNG.day2;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.reusableMethods.methods.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_HandleWindows extends TestBase {

    @Test
    public void test() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        //2- Url'nin amazon içerdiğini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.bestbuy.com')"); //Burada yeni pencere aç dedik
        ReusableMethods.switchToWindows(driver);


        //4- title'in BestBuy içerdiğini test edelim
        Assert.assertFalse(driver.getTitle().contains("BestBuy"));
        String bestBuyWindowHandle = driver.getWindowHandle();

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement sonucYazi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananSonucYazisi = "Java";
        String gelenYazi = sonucYazi.getText();
        Assert.assertTrue(gelenYazi.contains(arananSonucYazisi));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Best Buy Logo']")).isDisplayed());

        //9- Sayfaları Kapatalım
        driver.quit();
    }


}