package com.cydeo.tests.tests.lectureArchive.selenium.day_1_2_SeleniumIntro;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasicNavigations extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//Makes the full screen
        //get and navigate are have same function but navigate has more options/features

        //Stop code execution for 3 seconds
        Thread.sleep(1);

        driver.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
        ReusableMethods.waitForPageToLoad(driver,1);

        //Stop code execution for 3 seconds
        Thread.sleep(3000);
        driver.navigate().to("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/0.htm");

        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        driver.navigate().refresh();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // this will close the currently opened window by driver
        driver.close();

    }

    @Test
    public void testAllLinksOnTheMainPage() {
        driver.get("https://mustafaalicetinkaya.github.io/MustafaAliCetinkaya/index.htm");
        List<String> allPages = new ArrayList<>();
        for (int i = 1; i < 12; i++) {//Firstly, inspect your site, set the breakpoint of "i" based on the number of "href tags" on the page
            //This loop finds all href tags and store their values in allPages list
            String eachAddress = driver.findElement(By.xpath("(//a[@href])[" + i + "]")).getAttribute("href");
            allPages.add(eachAddress);
        }

        System.out.println("Number of the links on the page is: "+allPages.size());

        for (String each : allPages) {//This loop opens each link on a new tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('" + each + "', '_blank');");
        }


        Set<String> AllHandles = driver.getWindowHandles();
        int count = 1;
        for (String eachHandle : AllHandles) {//Navigate each tab and get title/URL
            driver.switchTo().window(eachHandle);
            System.out.println(count + ". page title is : " + driver.getTitle() + "\n" +
                    count + ". link is: " + driver.getCurrentUrl());
            driver.switchTo().parentFrame();
            count++;
        }

    }
}
