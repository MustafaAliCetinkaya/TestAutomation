package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage() {       //driver
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // alt + insert

    @FindBy(xpath = "//input[@name=\"full_name\"]")
    public WebElement nameInput;

    @FindBy(xpath="//input[@name=\"email\"]")
    public WebElement emailInput;

    @FindBy(xpath="//button[@name=\"wooden_spoon\"]")
    public WebElement btn;

    public void login(String username, String email){
        emailInput.sendKeys(email);
        nameInput.sendKeys(username);
        btn.click();
    }




}