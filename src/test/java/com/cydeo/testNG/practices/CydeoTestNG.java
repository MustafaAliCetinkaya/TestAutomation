package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.methods.ReusableMethods;
import com.cydeo.reusableMethods.pages.CydeoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest() throws InterruptedException {
        driver.get("https://cydeo.com");

        String expectedTitle = "Cydeo";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");

        navigateThePage();

        ReusableMethods.switchToWindows();

        cydeoShopDropDownTest();
        cydeoShopping();
        onlyIdAttributes();

        driver.quit();
    }
}
