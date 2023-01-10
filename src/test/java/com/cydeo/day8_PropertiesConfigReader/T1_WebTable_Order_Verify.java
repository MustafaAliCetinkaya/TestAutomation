package com.cydeo.day8_PropertiesConfigReader;
import com.cydeo.day7_actionsWebTablesJavaFakerConfigReader.WebTableUtils;
import com.cydeo.reusableMethods.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_WebTable_Order_Verify extends TestBase implements WebTableUtils {

    @Test
    public void order_name_verify_test() {
        driver.get("https://practice.cydeo.com/web-tables");

        //Locate the cell that has Bob Martin text in it.
        WebElement bobMartinCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        //System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();

        Assert.assertEquals(actualBobName, expectedBobName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"
        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinDateCell.getText();

        Assert.assertEquals(actualBobDate, expectedBobDate);

    }

    //We use the utility method we created.
    @Test
    public void test2() {
        driver.get("https://practice.cydeo.com/web-tables");

        String costumerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("costumerOrderDate1 = " + costumerOrderDate1);


        String costumerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("costumerOrderDate2 = " + costumerOrderDate2);

    }

    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3() {

        driver.get("https://practice.cydeo.com/web-tables");

        WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");

    }

    @Test
    public void test4() {

        driver.get("https://practice.cydeo.com/web-tables");

        String address=returnOrderAddress(driver, "Bart Fisher");
        System.out.println("Client: Bart Fisher"+"\n"+address);
    }

    @Test
    public void test5() {

        driver.get("https://practice.cydeo.com/web-tables");

        String paymentDetails=returnCheckoutInfo(driver, "Robert Baratheon");
        System.out.println("Client: Bart Fisher"+"\n"+"Credit Card Details: "+"\n"+paymentDetails);
    }

    @Test
    public void test6() {

        driver.get("https://practice.cydeo.com/web-tables");

        String orderDetails=returnOrderInfo(driver, "Stewart Dawidson");
        System.out.println("Stewart Dawidson's order details: "+"\n"+orderDetails);
    }
}