package com.cydeo.tests.tests.lectureArchive.selenium.day_1_2_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElements03 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 1- https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        // 2- cookies cikarsa kabul et butonuna basin

        // 3- sayfada kac adet button bulundugunu yazdirin

        List<WebElement> buttonListesi = driver.findElements(By.tagName("button"));
        System.out.println(buttonListesi.size());

        // 4- sayfadaki herbir button uzerindeki yazilari yazdirin

        for (WebElement each : buttonListesi) {
            System.out.println(each.getText());
        }
        driver.close();
    }
}