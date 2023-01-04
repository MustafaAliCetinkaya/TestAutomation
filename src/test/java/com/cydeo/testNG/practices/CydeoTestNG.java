package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.pages.CydeoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest(){
        driver.get("https://cydeo.com");
        String expectedTitle = "Cydeo";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");

        onlyIdAttributes();
    }
}
