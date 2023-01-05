package com.cydeo.testNG.day2;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {

    @Test
    public void test(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

       /*
        Eğer kontrolsüz açılan bir tab veya window varsa
        o zaman sayfaların window handle değerlerini elde etmemiz gerekir
        Öncelikle 2. sayfa açılmadan önce
        İlk sayfanın window handle değerini String'e atayalım

         */

        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        /*Ahmet H.
        switchTo().newWindow() demeden link tıklayarak yeni tab veya window oluştuğunda
        biz driver e yeni sayfaya geç demedikçe, driver eski sayfada kalır
        ve yeni sayfa ile ilgili hiçbir işlem yapamaz
        yeni sayfada driver i çalıştırmak isterseniz
        önce driver i yeni sayfaya yollamalısınız.
         */

        /*Ahmet H.
        Yeni sayfaya geçebilmek için öncelikle ikinciSayfaWindowHandleDegeri'ni bulmamız gerekiir
        bunun için driver.getWindowHandle() methodunu kullanarak
        acık olan tum sayfaların window handle degerini alıp bir Set e assing ederiz

        ilk sayfanın window handle değerini zaten biliyoruz
        Set deki window handle degerlerini kontrol edip
        ilk sayfanın handle degerine eşit olmayan
        ikinci sayfanın window handle degeridir deriz
         */

        /*Ahmet H.
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri=" ";

        for (String each:windowHandleSeti) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                String ikinciSayfaWindowHandleDegeri = each;
            }
        }

        //artık ikinci sayfanın window handle değerini biliyoruz
        //rahatlıkla sayfalar arası geçiş yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

         */

        /*Ahmet H.
        String expectedTitle = "New Window";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

         */

        /*
        todo *** yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
         bunun icin driver.getWindowHandles() method'unu kullanarak
         acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
         *** İlk sayfanin window handle degerini zaten biliyoruz
         *** Set'deki window handle degerlerini kontrol edip
         *** ilk sayfanin handle degerine esit olmayan
         *** İkinci sayfanin window handle degeridir deriz


        /**Erol H.
         Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
         bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
         atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
         ve ikinci acilan pencere veya sekmede islem yapabilmek icin
         driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
         */

        //Erol H.
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());//sayfalar arası geçiş kolay olsun diye bu şekilde çözdük.
        System.out.println("Window Handle degerleri :"+windowList);
        driver.switchTo().window(windowList.get(1));

        /**Erol H.
         NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
         açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.
         Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
         hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.
         Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))
         Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
         0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
         */



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
        driver.switchTo().window(windowList.get(0)); //İlk sayfaya dönmek için get içine (0) koymamız lazım
        //1. yol:
        Assert.assertEquals("The Internet",driver.getTitle());
        //2. yol:
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}