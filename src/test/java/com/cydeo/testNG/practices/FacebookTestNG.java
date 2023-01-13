package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.base.TestBaseBeforeClassAfterClass;
import com.cydeo.reusableMethods.pages.FacebookPage;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class FacebookTestNG extends TestBaseBeforeClassAfterClass implements FacebookPage {
    @Test
    public void facebookTest(){
        driver.get(ConfigurationReader.getProperty("facebook"));
        facebookLogin("karaca@gmail.com","Karaca.098756");
    }

    @Test

    public void facebookTest2(){
        //driver.get(ConfigurationReader.getProperty("facebook"));
        FacebookPage.facebookLogin();
    }
}
