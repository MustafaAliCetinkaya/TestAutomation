package com.cydeo.tests.tests.lectureArchive.reviewSessions.officeHour;

import com.cydeo.pages.ConfirmationPage;
import com.cydeo.pages.SignUpPage;
import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    SignUpPage signUpPage = new SignUpPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();


    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");


        // first way to use singup page
//        signUpPage.nameInput.sendKeys("John");
//        signUpPage.emailInput.sendKeys("abc@abc.com");
//        signUpPage.btn.click();

        // second way to use signup page
        signUpPage.login("John","abc@abc.com");


        String actualText = confirmationPage.text.getText();
        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualText,expectedText);

        driver.close();



    }
}