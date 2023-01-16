package com.cydeo.testNG.practices;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GroupStudy implements WebTableUtils {

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterClass
    public static void tearDown(){
        Driver.getDriver().quit();
    }

    @Test (dependsOnMethods = {"smartBearLoginTest"})
    public void smartBearGetPaymentInfoTest(){
        smartBearPaymentInfo("Canada");
    }

    @Test
    public void smartBearLoginTest(){
        smartBearLogin();
    }

    @Test(dependsOnMethods = {"smartBearLoginTest"})
    public void smartBearGettingLinksTest(){
        smartBearGetAllLinks();
    }

    public static void smartBearGetAllLinks() {

        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//a[@href]"));

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }
    }

    public static void smartBearLogin() {

        WebElement username = Driver.getDriver().findElement(By.cssSelector("input#ctl00_MainContent_username"));
        WebElement password = Driver.getDriver().findElement(By.cssSelector("input#ctl00_MainContent_password"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginButton.click();

        if(Driver.getDriver().getTitle().equalsIgnoreCase("Web Orders"))
            System.out.println("Driver successfully logged into the site.");
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
}


