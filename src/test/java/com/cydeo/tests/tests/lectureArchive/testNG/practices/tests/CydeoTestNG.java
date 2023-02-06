package com.cydeo.tests.tests.lectureArchive.testNG.practices.tests;

import com.cydeo.tests.tests.lectureArchive.testNG.practices.pages.CydeoPage;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class CydeoTestNG extends CydeoPage {

    @Test
    public void cydeoTest() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("cydeo"));
        ReusableMethods.verifyPageTitle(driver, "Cydeo");

        navigateThePage();
        ReusableMethods.switchToWindows(driver);//Switches to new tab
        cydeoShopDropDownTest();
        cydeoShopping();
        onlyIdAttributes();

    }

    @Test
    public void testAllLinksOnTheMainPage() {
        driver.get(ConfigurationReader.getProperty("cydeo"));
        ReusableMethods.verifyPageTitle(driver, "Cydeo");

        testAllLinksOnTheHomepage();

    }
}
