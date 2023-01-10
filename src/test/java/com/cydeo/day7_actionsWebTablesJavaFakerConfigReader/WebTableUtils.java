package com.cydeo.day7_actionsWebTablesJavaFakerConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public interface WebTableUtils {

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.

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

}