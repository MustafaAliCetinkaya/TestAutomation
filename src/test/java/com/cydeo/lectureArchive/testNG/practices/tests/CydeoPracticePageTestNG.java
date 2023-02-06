package com.cydeo.lectureArchive.testNG.practices.tests;

import com.cydeo.lectureArchive.testNG.practices.pages.CydeoPracticePage;
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
    public void practiceDropdowns() {
        driver.get(ConfigurationReader.getProperty("practice"));
        dropDowns();
    }

    @Test
    public void practiceFrames() {
        driver.get(ConfigurationReader.getProperty("practice"));
        frames();
    }

    @Test
    public void practiceWebTables() {
        driver.get(ConfigurationReader.getProperty("practice"));
        webTables();
    }
}
