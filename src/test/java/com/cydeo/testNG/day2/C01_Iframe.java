package com.cydeo.testNG.day2;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_Iframe extends TestBase {

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○ Text Box’a “Merhaba Dunya!” yazin.
    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin
     */


    @Test
    public void test() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());//isEnable() ile erişilebilir olduğunu test ediyoruz
        System.out.println(baslikElementi.getText());

        //○ Text Box’a “Merhaba Dunya!” yazin.

        /**
        //textBox ı doğru olarak locate ettiğimiz halde driver bulamadı
        //bunun üzerine HTML kodlarını inceleyince
        //textbox'ın aslında bir IFrame içerisinde olduğunu gördük
        //bu durumda önce iframe i locate edip
        //switchTo() ile o ifram e geçmeliyiz
         */

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi); //Burada önce iframe e geçtik

        Thread.sleep(2000);

        WebElement textKutusu = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textKutusu.clear();//Burada ise iframe nin olduğu kutuyu temizleyip
        textKutusu.sendKeys("Merhaba Dunya!");//içine yazı gönderdik

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin

        /*
        linkYaziElementini doğru locate etmemize rağmen yazdırmadı
        çünkü yukarıda iframe e geçiş yapmıştık
        önce oradan çıkmamız lazım
         */
        //driver.switchTo( ).parentFrame( ); 1 ust seviyedeki frame’e cikartir
        //driver.switchTo( ).defaultContent( ); En ustteki frame’e cikmak icin kullanilir

        driver.switchTo().defaultContent();//en üstteki fame çıkmak için kullanılır


        WebElement linkYaziElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());


    }





}
 /**
    Iframe nedir?

    ➢ IFrame, bir web sayfasına icine yerlestirilmis baska
    bir web sayfasıdır veya bir HTML dokumaninin içine
    yerleştirilmiş baska bir HTML dokumanidir.

    ➢ IFrame genellikle bir Web sayfasına dokuman, video
    veya interaktif media gibi başka bir kaynaktan içerik
    eklemek için kullanılır. <iframe> tag’ı bir inline frame
    belirtir.
     */

 /**
 ● Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan göremez
● switchTo( ) mettod’u ile iframe’e gecmenin 3 yolu vardir;
1 ) index ile :
driver.switchTo( ).frame(index of the iframe); //index 0’dan baslar
2 ) id veya name value ile
driver.switchTo( ).frame("id of the iframe");
3 ) WebElement ile
driver.switchTo( ).frame(WebElement of the iframe);

  */