package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPage {
    public WebDriver driver = Driver.getDriver();

    public CydeoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Tümünü Kabul Et']")
    public static WebElement cookies;
}
