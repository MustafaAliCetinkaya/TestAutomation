package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CydeoPracticePage {

    public static WebDriver driver = Driver.getDriver();

    public CydeoPracticePage() {
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(xpath = "//a[@href]")})
    public static List<WebElement> allLinks;

    @FindAll({@FindBy(xpath = "//div")})
    public static List<WebElement> allElements;

    public static void onlyIdAttributes() {
        System.out.println("AllIdentities.size() = " + allElements.size());
        int count = 1;
        for (WebElement each : allElements) {
            String eachId = each.getAttribute("id");
            System.out.println(!(eachId.isEmpty() || eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!");
            count++;
        }
    }

    public static void navigateThePage() {
        List<String> allPages = new ArrayList<>();
        int count = 1;
        for (WebElement eachLink : allLinks) {
            System.out.println(count + ". link is: " + eachLink.getAttribute("href"));
            allPages.add(eachLink.getAttribute("href"));
            count++;
        }

        int temp = 1;
        for (String each : allPages) {
            driver.navigate().to(each);
            System.out.println(temp+". page title is: "+driver.getTitle());
            temp++;
            driver.navigate().back();
        }
    }


}
