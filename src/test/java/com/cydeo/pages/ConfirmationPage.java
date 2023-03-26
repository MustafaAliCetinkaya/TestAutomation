package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    public ConfirmationPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "subheader")
    public WebElement text;
}