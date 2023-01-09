package com.cydeo.testNG.practices;

import com.cydeo.reusableMethods.pages.CydeoPracticePage;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class CydeoPracticePageTestNG extends CydeoPracticePage {
    @Test
    public void cydeoPracticePageTest() {
        driver.get(ConfigurationReader.getProperty("practice"));

        onlyIdAttributes();
        navigateThePage();
    }

    @Test
    public void practicePages() {
        driver.get(ConfigurationReader.getProperty("practice"));
        dropDowns();
    }

    @Test
    public void practiceFrames() {
        driver.get(ConfigurationReader.getProperty("practice"));
        frames();
    }
}
