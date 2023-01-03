package com.cydeo.testNG;

import com.cydeo.reusableMethods.pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AmazonTestNG extends AmazonPage {
    AmazonPage pageObject = new AmazonPage();

    @Test
    public void amazonShopping() {

        driver.get("https://www.amazon.com");
        pageObject.searchBox.sendKeys("nutella"+ Keys.ENTER);

    }
}
