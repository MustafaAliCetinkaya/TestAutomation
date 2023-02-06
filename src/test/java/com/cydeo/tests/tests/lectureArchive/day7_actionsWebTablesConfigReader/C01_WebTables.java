package com.cydeo.tests.tests.lectureArchive.day7_actionsWebTablesConfigReader;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test1() {
        driver.get("https://practice.cydeo.com/tables");//When we sort the table, everything is reordered in it.

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

        System.out.println("*****************************************");

        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList) {
            System.out.println(each.getText()); //Burada da tek tek hücreleri yazdırdık
        }

        System.out.println("*****************************************");

        //Email başlığındaki tüm elementleri(sutun) konsolda yazdırın
        //önce email başlığının kaçıncı sütunda olduğunu bulalım
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
                break;
            }
        }
        System.out.println("*****************************************");

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailSutunListesi) {
            System.out.println(each.getText());
        }

        //BirthDate başlığındaki tüm elementleri(sutun) konsolda yazdırın
        int borcSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Due")){
                borcSutunNo=i;
                break;
            }
        }
        System.out.println("*****************************************");

        List<WebElement> borcSutunListesi = driver.findElements(By.xpath("//tbody//td["+(borcSutunNo+1)+"]"));
        for (WebElement each:borcSutunListesi) {
            System.out.println(each.getText());
        }

    }

    public void table() {
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi :" +sutunBasliklariListesi.size());
        for (WebElement eachHeader : sutunBasliklariListesi) {
            System.out.print(eachHeader.getText()+" ");
        }

        System.out.println();

        WebElement allBodyExample1 = driver.findElement(By.xpath("(//tbody)[1]"));
        WebElement allBodyExample2 = driver.findElement(By.xpath("(//tbody)[2]"));
        System.out.println(allBodyExample1.getText());
        System.out.println(allBodyExample2.getText());
        //Tüm body'i bir String olarak yazdırmak isterseniz
        //body webElementini locate edip getText() methodu ile yazdırabilirsiniz ama üzerinde gezemezsiniz

        /*
        list olunca driver.findElements olmalıdır
         */

        System.out.println("*****************************");

        WebElement headers= driver.findElement(By.xpath("//thead//tr"));  //başlık için thead olur
        System.out.println("Table Headers :"+headers.getText());
        System.out.println("*****************************");

        //thead-->Title başlıklari
        //tbody --> Title tablo

        //table row =tr
        //table header = th
        //table data= td

    }

  /*  public void login() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

        Actions actions = new Actions(driver);

        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(username).sendKeys("manager")
                .sendKeys(Keys.TAB).sendKeys("Manager1!")
                .sendKeys(Keys.ENTER).perform();

        Diğer yöntem
        //○ Username : manager
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        //○ Password : Manager1!
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!", Keys.ENTER);
         */



    }


