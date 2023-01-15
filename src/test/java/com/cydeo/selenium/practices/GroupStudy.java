package com.cydeo.selenium.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupStudy {
    static WebDriver driver;

    @BeforeMethod
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void smartBearTest(){
        smartBearUtil(driver);
    }
    /*public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement username = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginButton.click();

        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }
    }*/

    /*    @BeforeClass

        public void beforeClass(){
            System.out.println("This is before class method. It will run only once");
        }

        @AfterClass

        public void afterClass(){
            System.out.println("This is after class method. It will run only once");
        }

        @BeforeMethod

        public void beforeMethod(){
            System.out.println("This is before method. It will run many times.");
        }

        @AfterMethod

        public void afterMethod(){
            System.out.println("This is after method. It will run many times.");
        }

        @Test
        public void test1(){
            System.out.println("This is test1");
        }

        @Test
        public void test2(){
            System.out.println("This is test2");
        }*/
    public static void smartBearUtil(WebDriver driver) {

        WebElement username = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginButton.click();

        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }
    }

}


