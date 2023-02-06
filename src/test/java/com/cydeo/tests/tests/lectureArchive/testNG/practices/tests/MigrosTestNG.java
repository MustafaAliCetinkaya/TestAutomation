package com.cydeo.tests.tests.lectureArchive.testNG.practices.tests;

import com.cydeo.tests.tests.lectureArchive.testNG.practices.pages.CydeoPage;
import com.cydeo.tests.tests.lectureArchive.testNG.practices.pages.MigrosPage;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MigrosTestNG extends MigrosPage {

    @Test
    public void migrosShopping() throws InterruptedException {
        driver.get("https://www.migros.com.tr/");
        String expectedTitle = "Migros Sanal Market: Online Market Alışverişi";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "This is a failure message. Title is not matching!");

        acceptCookies();
        searchItem("nutella");
        addItem(findItem);
        fillAddressDetails();
        goToTheCart();

    }

    @Test
    public void testAllLinksOnTheMainPage() {
        driver.get(ConfigurationReader.getProperty("migros"));
        ReusableMethods.verifyPageTitle(driver, "Migros Sanal Market: Online Market Alışverişi");

        CydeoPage.testAllLinksOnTheHomepage();

    }
}
