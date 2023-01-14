package com.cydeo.testNG.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C05_BeforeClass_AfterClass_Notasyonlari {
    // Olusturdugumuz test class'inin icindeki test method'lari
    // hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    // ve her method icin bu driver'i kapatmaya gerek yoktur
    // Class'in basinda bir kere setup calisip, en sonda kapansa olur
    // dersek BeforeClass ve AfterClass kullaniriz
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // amazon ana sayfaya gidelim
        driver.get("https:www.amazon.com");
    }
    @Test @Ignore // @Ignore görmezden gel demek için kullanılır, test yaparken görmezden gelinir bu methodla
    public void test02() {
        // title yazdiralim
        System.out.println(driver.getTitle());
    }
    @Test
    public void test03() {
        // url yazdiralim
        System.out.println(driver.getCurrentUrl());
    }
}