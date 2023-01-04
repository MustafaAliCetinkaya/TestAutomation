package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver;
    }
}

    /*
    POM'de Driver icin TestBase class'ina extends etmek yerine
    Driver class'indan static method'lar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilmistir.

    POM'de Driver class'indaki getDriver()'in obje olusturularak kullanilmasini
    engellemek icin
    Singleton pattern kullanimi benimsenmistir

    Singleton Pattern : tekli kullanim, bir class'in farkli class'lardan
                        obje olusturarak kullanimini engellemek icin kullanilir

    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullanilan constructor'i private yaptiginizda
    baska class'larda Driver class'indan obje olusturulmasi mumkun OLMAZ
     */

// HER ZAMAN KULLANABİLECEGİMİZ HAZİR SABLON
