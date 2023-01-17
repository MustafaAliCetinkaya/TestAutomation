package com.cydeo.testNG.practices.tests;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.testNG.practices.pages.NextBaseCrmPage;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class NextBaseCrmTestNG extends TestBase implements NextBaseCrmPage {

    @Test
    public void crm_login_test(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get(ConfigurationReader.getProperty("env"));//Reusable, dynamic

        //Calling my utility method to login helpdesk1
        // Calling the static method of interface
        NextBaseCrmPage.crm_login();/*
        You can access static methods using the interface name.
        If your interface has a static method you need to call it using the name of the interface, just like static methods of a class.*/

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "(2) Portal");
    }
    @Test
    public void crm_login_test_1(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get(ConfigurationReader.getProperty("env"));//Reusable, dynamic

        //Calling my utility method to login helpdesk1
        crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "(1) My tasks");
    }

    @Test
    public void crm_login_test_2(){

        //2. Go to : https://login1.nextbasecrm.com/
        driver.get(ConfigurationReader.getProperty("env"));//Reusable, dynamic

        //Calling my utility method to login helpdesk
        crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser" );

        //6. Verify title is as expected:
        //Expected: Portal
        //BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }
}
