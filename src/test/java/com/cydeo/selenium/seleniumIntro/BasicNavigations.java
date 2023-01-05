package com.cydeo.selenium.seleniumIntro;

import com.cydeo.reusableMethods.methods.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
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
}
