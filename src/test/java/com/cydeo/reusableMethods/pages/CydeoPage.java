package com.cydeo.reusableMethods.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CydeoPage {
    public static WebDriver driver = Driver.getDriver();

    public CydeoPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Programs")
    public static WebElement programs;

    @FindBy(xpath = "//a[.='Java SDET']")
    public static WebElement javaSDET;

    @FindBy(xpath = "//a[.='Cybersecurity Analyst']")
    public static WebElement cyberSecurity;

    @FindBy(xpath = "//a[.='Java Developer']")
    public static WebElement javaDeveloper;

    @FindBy(xpath = "//a[.='Salesforce Administrator/Developer']")
    public static WebElement salesForce;

    @FindBy(linkText = "About")
    public static WebElement about;

    @FindBy(linkText = "Careers")
    public static WebElement careers;

    @FindBy(linkText = "Partnerships")
    public static WebElement partnerShips;

    @FindBy(xpath = "//a[.='Shop']")
    public static WebElement shop;

    @FindBy(xpath = "//button[@name='add']")
    public static WebElement addToCart;

    @FindBy(xpath = "//a[@id='cart-icon-bubble']")
    public static WebElement goToCart;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[2]")
    public static WebElement longSleeve;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[6]")
    public static WebElement hoodies;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[8]")
    public static WebElement youth;

    @FindBy(css = "button#checkout")
    public static WebElement checkout;

    @FindAll({@FindBy(xpath = "//div")})
    public static List<WebElement> allElements;

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
        programs.click();
        System.out.println("Page title is = " + driver.getTitle());

        javaSDET.click();
        System.out.println("Page title is = " + driver.getTitle());

        cyberSecurity.click();
        System.out.println("Page title is = " + driver.getTitle());

        javaDeveloper.click();
        System.out.println("Page title is = " + driver.getTitle());

        salesForce.click();
        System.out.println("Page title is = " + driver.getTitle());

        about.click();
        System.out.println("Page title is = " + driver.getTitle());

        careers.click();
        System.out.println("Page title is = " + driver.getTitle());

        partnerShips.click();
        System.out.println("Page title is = " + driver.getTitle());

        shop.click();
        System.out.println("Page title is = " + driver.getTitle());

    }

    public static void cydeoShopDropDownTest() {

        WebElement color = driver.findElement(By.xpath("//select[@name='options[Color]']"));
        Select colorDropDown = new Select(color);

        //Verify default selected option.
        String expectedOptionText = "Solid Black Triblend";
        String actualOptionText = colorDropDown.getFirstSelectedOption().getText();
        System.out.println(actualOptionText);

        Assert.assertEquals(actualOptionText, expectedOptionText, "Default selected color option test is failed!");

        WebElement size = driver.findElement(By.xpath("//select[@name='options[Size]']"));
        Select sizeDropDown = new Select(size);

        //Verify default selected option.
        String expectedSizeOptionText = "XS";
        String actualSizeOptionText = sizeDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSizeOptionText, expectedSizeOptionText, "Default selected size option test is failed!");

    }

    public static void cydeoShopping() throws InterruptedException {

        WebElement color = driver.findElement(By.xpath("//select[@name='options[Color]']"));
        Select colorDropDown = new Select(color);

        WebElement size = driver.findElement(By.xpath("//select[@name='options[Size]']"));
        Select sizeDropDown = new Select(size);

        colorDropDown.selectByIndex(1);
        sizeDropDown.selectByIndex(1);
        addToCart.click();

        Thread.sleep(5000);

        colorDropDown.selectByValue("True Royal Triblend");
        sizeDropDown.selectByValue("2XL");
        addToCart.click();

        Thread.sleep(5000);

        longSleeve.click();
        driver.findElement(By.xpath("(//a[contains(text(),'Unisex')])[2]")).click();
        addToCart.click();
        for (int i = 0; i < 2; i++) {
            driver.navigate().back();
        }

        Thread.sleep(5000);

        hoodies.click();
        driver.findElement(By.xpath("(//a[contains(text(),'Zip')])[2]")).click();
        addToCart.click();
        for (int i = 0; i < 2; i++) {
            driver.navigate().back();
        }

        Thread.sleep(5000);

        youth.click();
        driver.findElement(By.xpath("(//a[contains(text(),'long')])[2]")).click();
        addToCart.click();

        goToCart.click();
        checkout.click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("Enough for practice!");
    }
}
