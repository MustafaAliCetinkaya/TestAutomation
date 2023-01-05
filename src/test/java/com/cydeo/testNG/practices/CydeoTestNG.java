package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.pages.CydeoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest() throws InterruptedException {
        driver.get("https://cydeo.com");

        String expectedTitle = "Cydeo";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");

        navigateThePage();

        Set<String> AllHandles=driver.getWindowHandles();
        for (String eachHandle : AllHandles) {
            driver.switchTo().window(eachHandle);
        }

        cydeoShopDropDownTest();
        cydeoShopping();
        onlyIdAttributes();

        driver.quit();
    }
}
