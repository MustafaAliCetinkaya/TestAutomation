package com.cydeo.reusableMethods.pages;

import com.cydeo.reusableMethods.base.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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
        int count = 1;
        for (WebElement eachLink : allLinks) {
            System.out.println(count + ". link is: " + eachLink.getAttribute("href"));
            allPages.add(eachLink.getAttribute("href"));
            count++;
        }

        int temp = 1;
        for (String each : allPages) {
            driver.navigate().to(each);
            System.out.println(temp + ". page title is: " + driver.getTitle());
            temp++;
            driver.navigate().back();
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
        for (int i = 0; i <3 ; i++) {
            driver.switchTo().frame(i);
            WebElement body=driver.findElement(By.tagName("body"));
            System.out.println("Body test is: "+body.getText());
            driver.switchTo().parentFrame();
        }
    }


}
