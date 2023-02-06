package com.cydeo.lectureArchive.day9_10_JavaFakerTestBaseDriverUtil;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.miscellaneous.ReusableMethods;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUpload extends TestBase {
    @Test
    public void fileUploadTest() {
        driver.get(ConfigurationReader.getProperty("practice"));
        driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();

        String filePath="/Users/mustafacetinkaya/Downloads/script33.js";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        ReusableMethods.waitFor(3);
        driver.findElement(By.id("file-submit")).click();
        ReusableMethods.waitFor(3);

        /*Alert alert=driver.switchTo().alert();
        alert.accept();*/

    }
}
