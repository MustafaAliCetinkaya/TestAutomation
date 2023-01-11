package com.cydeo.reusableMethods.base;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBaseBeforeClassAfterClass {

    //abstract yapmamızın tek sebebi bu classdan obje üretilmesinin önüne geçmektir

    public static WebDriver driver;
    public static Actions actions;
    public static Faker faker;


    @BeforeClass
    public static void setUp(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        faker = new Faker();
    }

    @AfterClass
    public static void tearDown(){
        Driver.closeDriver();
    }

}