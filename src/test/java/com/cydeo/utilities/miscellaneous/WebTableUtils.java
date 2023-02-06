package com.cydeo.utilities.miscellaneous;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public interface WebTableUtils {

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.
//Below written methods are created for the table infos on the https://practice.cydeo.com/web-tables website.
    public static String returnOrderDate(WebDriver driver, String customerName) {
        String locator = "//td[.='" + customerName + "']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();
    }

    public static String returnOrderDate2(WebDriver driver, String customerName) {
        return driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[3]")).getText();
    }

    //Method #2 info:
    //• Name: orderVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String customerName
    //• Arg3: String expectedOrderDate
    //This method should accept above-mentioned arguments and internally assert
    //expectedOrderDate matching actualOrderDate.

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate) {

        String locator = "//td[.='" + customerName + "']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

    default String returnOrderAddress(WebDriver driver, String customerName) {
        String address = "Order Address: ";
        for (int i = 4; i < 8; i++) {
            String locator = "//td[.='" + customerName + "']/following-sibling::td[" + i + "]";
            address += driver.findElement(By.xpath(locator)).getText() + " ";
        }
        return address;
    }

    default String returnCheckoutInfo(WebDriver driver, String customerName) {
        String checkoutInfo = "Payment Details: ";
        for (int i = 8; i < 11; i++) {
            String locator = "//td[.='" + customerName + "']/following-sibling::td[" + i + "]";
            checkoutInfo += driver.findElement(By.xpath(locator)).getText() + " ";
        }
        return checkoutInfo;
    }

    default String returnOrderInfo(WebDriver driver, String customerName) {
        String returnOrderInfo = "Order Details: ";
        for (int i = 1; i < 3; i++) {
            String locator = "//td[.='" + customerName + "']/following-sibling::td[" + i + "]";
            returnOrderInfo += driver.findElement(By.xpath(locator)).getText() + " ";
        }
        return returnOrderInfo;
    }

    //Below written methods are created for the table infos on the http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx website.
    default String smartBearOrderInfo(String customerName) {
        String returnOrderInfo = "Order Details: ";
        for (int i = 1; i < 3; i++) {
            String locator = "//td[.='" + customerName + "']/following-sibling::td[" + i + "]";
            returnOrderInfo += Driver.getDriver().findElement(By.xpath(locator)).getText() + " ";
        }
        return returnOrderInfo;
    }

    default void smartBearPaymentInfo(String stateName) {//Must ve completed. Contains bug!
        List<WebElement> allCustomersAtTheSameState=Driver.getDriver().findElements(By.xpath("//td[.='" + stateName + "']"));


        for (WebElement eachWebElement : allCustomersAtTheSameState) {
            String returnOrderInfo="";
            String temp="Order Details Which are Given From "+stateName+": ";
            for (int i = 6; i > 3; i--) {
                String locator = "//td[.='" + eachWebElement.getText() + "']/preceding-sibling::td[" + i + "]";
                temp+=Driver.getDriver().findElement(By.xpath(locator)).getText() + " ";
            }
            returnOrderInfo+=temp;
            System.out.println(returnOrderInfo);
        }

    }
}