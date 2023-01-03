package com.cydeo.testNG;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.reusableMethods.pages.AmazonPage;
import org.testng.annotations.Test;

public class AmazonTestNG extends TestBase {

    @Test
    public void amazonShopping(){

        driver.get("https://www.amazon.com");

        AmazonPage.searchItem("nutella");

    }
}
