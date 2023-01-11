package com.cydeo.day7_actionsWebTablesJavaFakerConfigReader;

import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test1() {

        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        login();

        //● table( ) metodu oluşturun
        table();

        //● printRows( ) metodu oluşturun //tr
        printRows();



    }

    public void printRows() {

        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi :"+satirlarListesi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: satirlarListesi) {
            System.out.println(each.getText());
        }

        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList) {
            System.out.println(each.getText()); //Burada da tek tek hücreleri yazdırdık
        }

        //Email başlığındaki tüm elementleri(sutun) konsolda yazdırın
        //önce email başlığının kaçıncı sütunda olduğunu bulalım
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailSutunListesi) {
            System.out.println(each.getText());
        }

        System.out.println("*****************************************");

        //BirthDate başlığındaki tüm elementleri(sutun) konsolda yazdırın
        int birthDateSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("BirthDate")){
                birthDateSutunNo=i;
            }
        }

        List<WebElement> birthDateSutunListesi = driver.findElements(By.xpath("//tbody//td["+(birthDateSutunNo+1)+"]"));
        for (WebElement each:birthDateSutunListesi) {
            System.out.println(each.getText());
        }


    }

    public void table() {
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi :" +sutunBasliklariListesi.size());

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        //Tüm body'i bir String olarak yazdırmak isterseniz
        //body webElementini locate edip getText() methodu ile yazdırabilirsiniz ama üzerinde gezemezsiniz

        /*
        list olunca driver.findElements olmalıdır
         */

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBodyTumBaslik = driver.findElements(By.xpath("//table//tbody")); //table deki dediği için table dendi
        System.out.println("body sayisi :"+tumBodyTumBaslik.size());  //sayısı yazdırıldı
        System.out.println("*****************************");

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body :"+body.getText());
        System.out.println("*****************************");

        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));  //başlık için thead olur
        System.out.println("basliklari :"+basliklar.getText());
        System.out.println("*****************************");

        //thead-->Title başlıklari
        //tbody --> Title tablo

        //table row =tr
        //table header = th
        //table data= td

    }

    public void login() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

        Actions actions = new Actions(driver);

        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(username).sendKeys("manager")
                .sendKeys(Keys.TAB).sendKeys("Manager1!")
                .sendKeys(Keys.ENTER).perform();
        /*
        Diğer yöntem
        //○ Username : manager
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        //○ Password : Manager1!
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!", Keys.ENTER);
         */



    }


}