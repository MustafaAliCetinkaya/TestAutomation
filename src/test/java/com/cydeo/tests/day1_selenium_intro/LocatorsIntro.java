package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        for (int i = 1; i <= 5; i++) {
            System.out.println("-------------   " + i + ". attempt    -------------------");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver.manage().window().maximize();

            driver.navigate().to("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
            Thread.sleep(2000);
            System.out.println(driver.getTitle() + " / " + driver.getCurrentUrl());

            WebElement hayatınMatematikLisanı = driver.findElement(By.linkText("Hayatın Matematik Lisanı"));
            hayatınMatematikLisanı.click();
            Thread.sleep(2000);
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            String expectedTitle = "Hayatın Matematik Lisanı";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Title verification PASSED!");
            } else {
                System.out.println("Title verification FAILED!!!");
            }

            String expectedUrl = "https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/hytnmtmtklsn.htm";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.equals(expectedUrl)) {
                System.out.println("URL verification PASSED!");
            } else {
                System.out.println("URL verification FAILED!!!");
            }
            System.out.println("------------------------------");

            WebElement icatVsKesif = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[5]/td/p/b/a/span"));
            icatVsKesif.click();
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + currentUrl);
            System.out.println(driver.getTitle());

            String expected_Url = "https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/ict.htm";
            if (expected_Url.equals(currentUrl)) {
                System.out.println("URL verification PASSED!");
            } else {
                System.out.println("URL verification FAILED!!!");
            }

            System.out.println("------------------------------");

            WebElement neredeSatilir = driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(6) > td > p > b > a > span"));
            neredeSatilir.click();
            Thread.sleep(2000);
            String current_Url = driver.getCurrentUrl();
            System.out.println("current_Url = " + current_Url);
            System.out.println(driver.getTitle());

            String wantedUrl = "https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/stlr.htm";
            if (wantedUrl.equals(current_Url)) {
                System.out.println("URL verification PASSED!");
            } else {
                System.out.println("URL verification FAILED!!!");
            }
            driver.close();
        }
        driver.quit();
    }
}
