package com.cydeo.selenium.day_1_2_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetMethods {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();


        //6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        System.out.println("-------------------------------------");
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");
        // 2- driver.getTitle() --> icinde oldugu sayfanin basligini döndürür
        System.out.println("sayfa title : " + driver.getTitle()); //Amazon.com. Spend less. Smile more.

        // 3- driver.getCurrentUrl() --> icinde oldugu sayfanin URL'ini döndürür
        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        // 4- driver.getPageSource(); --> icinde oldugu sayfanin kaynak kodlarini döndürür
        System.out.println("=====================================================");
        System.out.println(driver.getPageSource()); // arka planda calisan sayfa kodlarini yazdirir
        System.out.println("=====================================================");

        // 5- driver.getWindowHandle() --> icinde oldugu sayfanin UNIQUE hash kodunu döndürür
        System.out.println(driver.getWindowHandle()); // CDwindow-F4A35FD5413FE52C6DEB0B03CA6DFB9F

        // 6- driver.getWindowHandles() --> driver calisirken acilan tum sayfalarin UNIQUE hash kodunu döndürür
        driver.close();

    }
}
