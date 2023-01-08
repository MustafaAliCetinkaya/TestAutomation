package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.methods.ReusableMethods;
import com.cydeo.reusableMethods.pages.CydeoPracticePage;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class CydeoPracticePageTestNG extends CydeoPracticePage {
    @Test
    public void cydeoPracticePageTest() {
        driver.get(ConfigurationReader.getProperty("practice"));
        ReusableMethods.verifyPageTitle(driver, "Practice");

        onlyIdAttributes();
        navigateThePage();
    }
}
