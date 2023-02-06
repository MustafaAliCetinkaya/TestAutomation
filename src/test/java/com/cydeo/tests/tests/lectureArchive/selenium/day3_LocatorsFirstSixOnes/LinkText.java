package com.cydeo.tests.tests.lectureArchive.selenium.day3_LocatorsFirstSixOnes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
        driver.findElement(By.linkText("Hayatın Matematik Lisanı")).click();
        driver.findElement(By.linkText("İcat mı?, Keşif mi?")).click();
        driver.findElement(By.linkText("Nerede Satılır?")).click();
        driver.findElement(By.linkText("Bizim de Kralımız Var")).click();
        driver.findElement(By.linkText("Sağdan Say")).click();
        driver.findElement(By.linkText("Sıfır Deyip Geçme!")).click();
        driver.findElement(By.linkText("Çakıl Taşlarında Bilim")).click();
        driver.findElement(By.linkText("Kumsalda Final")).click();
        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[12]/td/p[1]/b/a")).click();

        driver.findElement(By.linkText("Tangents through an external point - Construction")).click();

        ArrayList<String> getTitle = new ArrayList<>();
        int count=0;
        for (int i = 0; i < 10; i++) {
            driver.navigate().back();
            getTitle.add(driver.getTitle() + " / " + driver.getCurrentUrl());
            count++;
        }

        System.out.println(getTitle);
        System.out.println("We click on the back button "+count+" times!");

        for (String each : getTitle) {
            System.out.println("Page URL = " + each.substring(each.indexOf("/")+2));
        }
        driver.quit();
    }
}
