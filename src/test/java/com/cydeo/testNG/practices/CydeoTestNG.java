package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.pages.CydeoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest() {
        driver.get("https://cydeo.com");

        String expectedTitle = "Cydeo";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");

        Set<String> AllHandles=driver.getWindowHandles();
        for (String eachHandle : AllHandles) {
            driver.switchTo().window(eachHandle);
        }
        driver.close();

        navigateThePage();
        cydeoShopDropDownTest();
        cydeoShopping();
        onlyIdAttributes();

        //driver.quit();
    }
}
