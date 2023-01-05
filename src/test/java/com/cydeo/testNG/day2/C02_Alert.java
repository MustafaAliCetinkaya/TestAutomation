package com.cydeo.testNG.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C02_Alert {

    /*
    Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
    ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){

        // ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        //1. yol:Burada gözümüzle kontrol ettiğimiz için direkt true yaptım
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).isDisplayed());

        //2. yol: Burada ise istenilen yazının  bu olduğunu test et dediğimiz için ise String ve WebElement atamasını yaptık.
        String expectedResuld = "You successfully clicked an alert";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        String actualResultYazisi = sonucYaziElementi.getText();
        Assert.assertEquals(expectedResuld,actualResultYazisi);

    }

    @Test
    public void test2(){

        //    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss(); //Bu işlem ile cansel yaptık
        //1. yol:
        //Assert.assertFalse(driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).isDisplayed());

        //2. yol: Burada ise istenilen yazının "successfuly" olmadığını test et dediğimiz için ise String ve WebElement atamasını yaptık.
        String istenmeyenYazi = "successfuly";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenYazi));


    }

    @Test
    public void test3(){

        //    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Ali");
        driver.switchTo().alert().accept();

        //1. yol:
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).isDisplayed());

        //2. yol:
        WebElement isim=driver.findElement(By.xpath("//*[text()='You entered: Ali']"));
        String expectedisim="Ali";
        String actualMessage=isim.getText();
        Assert.assertTrue(actualMessage.contains(expectedisim));

    }
}