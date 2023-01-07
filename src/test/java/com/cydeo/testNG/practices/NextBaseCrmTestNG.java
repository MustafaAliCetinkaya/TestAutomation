package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.reusableMethods.methods.BrowserUtils;
import com.cydeo.reusableMethods.pages.NextBaseCrmPage;
import org.testng.annotations.Test;

public class NextBaseCrmTestNG extends TestBase implements NextBaseCrmPage {

    @Test
    public void crm_login_test_1(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @Test
    public void crm_login_test_2(){

        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk
        crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser" );

        //6. Verify title is as expected:
        //Expected: Portal
        //BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }
}
