package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.methods.ReusableMethods;
import com.cydeo.reusableMethods.pages.CydeoPage;
import org.testng.annotations.Test;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest() throws InterruptedException {
        driver.get("https://cydeo.com");

        ReusableMethods.verifyPageTitle(driver, "Cydeo");

        navigateThePage();
        ReusableMethods.switchToWindows(driver);//Switches to new tab
        cydeoShopDropDownTest();
        cydeoShopping();
        onlyIdAttributes();

        driver.quit();
    }
}
