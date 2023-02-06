package com.cydeo.pages;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CydeoPracticePage extends TestBase {

    public static WebDriver driver = Driver.getDriver();

    public CydeoPracticePage() {
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(xpath = "//a[@href]")})
    public static List<WebElement> allLinks;

    @FindAll({@FindBy(xpath = "//div")})
    public static List<WebElement> allElements;

    @FindBy(xpath = "//*[@href=\"/dropdown\"]")
    public static WebElement dropDown;


    @FindBy(css = "a#dropdownMenuLink")
    public static WebElement dropDownLink;


    @FindBy(xpath = "//a[.='Facebook']")
    public static WebElement facebookLink;


    @FindBy(xpath = "//a[.='Frames']")
    public static WebElement frames;


    @FindBy(xpath = "//a[.='Nested Frames']")
    public static WebElement nestedFrames;

    @FindBy(xpath = "//a[.='Web Tables']")
    public static WebElement webTables;


    public static void onlyIdAttributes() {
        System.out.println("AllIdentities.size() = " + allElements.size());
        int count = 1;
        for (WebElement each : allElements) {
            String eachId = each.getAttribute("id");
            System.out.println(!(eachId.isEmpty() || eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!");
            count++;
        }
    }

    public static void navigateThePage() {
        List<String> allPages = new ArrayList<>();

        for (int i = 1; i < 53; i++) {//Get all links on the page

            String eachAddress = driver.findElement(By.xpath("(//a[@href])[" + i + "]")).getAttribute("href");
            allPages.add(eachAddress);
        }


        for (String each : allPages) {//Open each link in a new tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('"+each+"', '_blank');");
        }


        Set<String> AllHandles=driver.getWindowHandles();
        int count = 1;
        for (String eachHandle : AllHandles) {//Navigate each tabs and get title/URL
            driver.switchTo().window(eachHandle);
            System.out.println(count + ". page title is : " + driver.getTitle()+"\n"+
            count + ". link is: " + driver.getCurrentUrl());
            driver.switchTo().parentFrame();
            count++;
        }
    }

    public static void dropDowns() {
        dropDown.click();
        Select select = new Select(driver.findElement(By.cssSelector("select#dropdown")));
        List<WebElement> allSimpleDropdownOptions = select.getOptions();
        for (WebElement eachOption : allSimpleDropdownOptions) {
            System.out.println(eachOption.getText());
        }
        System.out.println("Default selection is: " + select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        select.selectByIndex(2);

        Select selectYear = new Select(driver.findElement(By.cssSelector("select#year")));

        List<WebElement> allYearOptions = selectYear.getOptions();
        for (WebElement eachOption : allYearOptions) {
            System.out.println(eachOption.getText());
        }
        System.out.println("Default selection is: " + selectYear.getFirstSelectedOption().getText());
        selectYear.selectByVisibleText("1925");
        selectYear.selectByValue("1939");
        selectYear.selectByIndex(29);

        Select selectMonth = new Select(driver.findElement(By.cssSelector("select#month")));

        List<WebElement> allMonthOptions = selectMonth.getOptions();
        for (WebElement eachOption : allMonthOptions) {
            System.out.println(eachOption.getText());
        }
        System.out.println("Default selection is: " + selectMonth.getFirstSelectedOption().getText());
        selectMonth.selectByVisibleText("May");
        selectMonth.selectByValue("7");
        selectMonth.selectByIndex(11);


        Select selectState = new Select(driver.findElement(By.cssSelector("select#state")));

        List<WebElement> allStateOptions = selectState.getOptions();
        for (WebElement eachOption : allStateOptions) {
            System.out.println(eachOption.getText());
        }
        System.out.println("Default selection is: " + selectState.getFirstSelectedOption().getText());
        selectState.selectByVisibleText("Utah");
        selectState.selectByValue("LA");
        selectState.selectByIndex(23);

        dropDownLink.click();
        facebookLink.click();
    }

    public static void frames() {
        frames.click();
        nestedFrames.click();
        driver.switchTo().frame(0);
        for (int i = 0; i < 3; i++) {
            driver.switchTo().frame(i);
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.println("Body test is: " + body.getText());
            driver.switchTo().parentFrame();
        }
    }

    public static void webTables() {
        webTables.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr//td[2]"));
        int count = 1;
        for (WebElement eachNames : allNames) {
            System.out.println(count + ". name on the table is: " + eachNames.getText());
            count++;
        }


        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]//tr"));
        int temp = 1;
        for (WebElement eachRow : allRows) {
            System.out.println(temp + ". row info on the table is: " + eachRow.getText());
            temp++;
        }


        List<WebElement> selectedColumn = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[8]"));
        for (WebElement eachRow : selectedColumn) {
            System.out.println(eachRow.getText().equals("US") ? "United States of America" : eachRow.getText());
        }

    }
}
