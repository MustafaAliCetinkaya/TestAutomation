package com.cydeo.utilities.miscellaneous;
// TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chromeBrowser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            return null;
        }
    }

    public static WebDriver getDriver(int browserNumber) {
         WebDriver driver;

        switch (browserNumber) {

            case 1:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case 2:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            case 3:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Given browser type does not exist/or is not currently supported: "+browserNumber);
                driver=null;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;

    }
}
