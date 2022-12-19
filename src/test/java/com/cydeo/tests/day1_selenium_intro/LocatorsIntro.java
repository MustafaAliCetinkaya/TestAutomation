package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.navigate().to("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
        WebElement hayatınMatematikLisanı = driver.findElement(By.linkText("Hayatın Matematik Lisanı"));
        hayatınMatematikLisanı.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String expectedTitle="Hayatın Matematik Lisanı";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        System.out.println("--------------------------------");

        String expectedUrl="https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/hytnmtmtklsn.htm";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!!!");
        }

        System.out.println("--------------------------------");

        WebElement icatVsKesif = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[5]/td/p/b/a/span"));
        icatVsKesif.click();
        String currentUrl= driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
    }
}
