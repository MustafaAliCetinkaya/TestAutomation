package com.cydeo.lectureArchive.selenium.practices;

import com.cydeo.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class ToDoMvc {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://todomvc.com");
        //Click on the related links
        driver.findElement(By.xpath("//*[.='JavaScript']")).click();
        driver.findElement(By.xpath("(//*[.='Polymer'])[2]")).click();

        //TODO items are added (2 items)
        Faker faker = new Faker();
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.cssSelector("input#new-todo"))
                    .sendKeys(faker.chuckNorris().fact().replaceAll("Chuck Norris", "Mustafa" + Keys.ENTER));

            BrowserUtils.sleep(2);
        }

        //Second TODO item is selected, cleared and reassigned
        Actions actions = new Actions(driver);
        WebElement secondToDoItem = driver.findElement(By.xpath("(//label[@class='style-scope td-item'])[2]"));
        actions.doubleClick(secondToDoItem)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE).pause(15000)
                .sendKeys(faker.chuckNorris().fact()).pause(5000)
                .sendKeys(Keys.ENTER).perform();

        driver.quit();
    }
}
