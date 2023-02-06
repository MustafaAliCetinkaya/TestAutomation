package com.cydeo.utilities.miscellaneous;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver getDriver(String browserType) {
        String systemType = System.getProperty("os.name");
        System.out.println(systemType);

        if (systemType.contains("Mac") && browserType.equalsIgnoreCase("edge")) {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            driver= null;
        }
        else if (systemType.contains("Windows") && browserType.equalsIgnoreCase("safari")) {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            driver= null;
        }
        else {
            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;

                case "safari" :
                    driver=new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;
            }
        }

        return driver;
    }
}
