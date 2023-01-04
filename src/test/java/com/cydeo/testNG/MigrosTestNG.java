package com.cydeo.testNG;

import com.cydeo.reusableMethods.pages.MigrosPage;
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
}
