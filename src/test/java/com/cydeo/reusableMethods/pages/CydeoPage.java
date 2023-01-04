package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CydeoPage {
    public WebDriver driver = Driver.getDriver();

    public CydeoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(xpath = "//div")})
    public static List<WebElement> allElements;

    public static void onlyIdAttributes(){
        System.out.println("AllIdentities.size() = " + allElements.size());
        int count = 1;
        for (WebElement each : allElements) {
            String eachId = each.getAttribute("id");
            System.out.println( !(eachId.isEmpty()||eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!" );
            count++;
        }
    }

}
