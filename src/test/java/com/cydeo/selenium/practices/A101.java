package com.cydeo.selenium.practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class A101 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        /*- Basically this line will allow our driver to wait UP TO given time if the driver cannot immediately locate a web element.
        - We write it one time, and it is applied to the whole driver session.
        - Driver does not have to wait until 10 seconds have ended. If it finds the web element before maybe in 2 second, 5 seconds it will continue with execution.*/

        //Go to: A101 page
        driver.get("https://www.a101.com.tr/");
        //Accept the cookies
        WebElement cookies = driver.findElement(By.xpath("//button[.='Kabul Et']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cookies);

        try {
            cookies.click();
        }
        catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookies);
        }

        //Below part is hard coding. Find the first item
        driver.findElement(By.xpath("(//a[@title=\"GİYİM & AKSESUAR\"])[1]")).click();
        //driver.findElement(By.cssSelector("a[data-value=\"1588\"]")).click(); Sometimes ElementNotClickable exemption is thrown
        driver.findElement(By.xpath("//a[@data-value='1588' and @title=\"Erkek İç Giyim\"]")).click();
        //driver.findElement(By.cssSelector("a[data-value=\"1589\"]")).click(); Sometimes ElementNotClickable exemption is thrown
        driver.findElement(By.xpath("//a[@data-value=\"1589\" and @title=\"Erkek Çorap\"]")).click();
        //driver.findElement(By.xpath("//label[.='40-45']")).click();   Sometimes ElementNotClickable exemption is thrown

        // Using for loop, it tries for 3 times.
        // If the element is located for the first time then it breaks from the for loop nad comeout of the loop

        //Before test, Confirm color and size checkboxes are NOT selected by default.
        System.out.println("Before test color.isSelected(), expecting false = " + driver.findElement(By.cssSelector("li.checkbox>input[value='SİYAH']")).isSelected());
        System.out.println("Before test size.isSelected(), expecting false = " + driver.findElement(By.cssSelector("li.checkbox>input#attributes_integration_size40-45")).isSelected());

        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(By.cssSelector("li.checkbox>input#attributes_integration_size40-45")).click();
                //driver.findElement(By.cssSelector("label[for=\"attributes_integration_colourSİYAH\"]")).click();  Sometimes ElementNotClickable exemption is thrown
                driver.findElement(By.cssSelector("li.checkbox>input[value='SİYAH']")).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //After test, Confirm color and size checkboxes must be selected by driver.
        System.out.println("After test color.isSelected(), expecting true = " + driver.findElement(By.cssSelector("li.checkbox>input[value='SİYAH']")).isSelected());
        System.out.println("After test size.isSelected(), expecting true = " + driver.findElement(By.cssSelector("li.checkbox>input#attributes_integration_size40-45")).isSelected());

        for (int i = 0; i <= 2; i++) {//This part throws staleElementExemption
            try {
                driver.findElement(By.xpath("//a[@title=\"Unisex Termal Bot Çorap Siyah\"]")).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Verify the color
        String expectedColor = "Siyah";
        String actualColor = driver.findElement(By.xpath("(//div[@class='selected-variant-text']//span)[2]")).getText();

        if (expectedColor.equalsIgnoreCase(actualColor))
            System.out.println("Color test is PASSED!");
        else
            System.out.println("Color test is FAILED!");

        //Add the item to the cart
        System.out.println("Before test size.isSelected(), expecting true = " + driver.findElement(By.cssSelector("a[title=\"40-45\"]")).isSelected());
        driver.findElement(By.cssSelector("a[title=\"40-45\"]")).click();
        System.out.println("After test size.isSelected(), expecting true = " + driver.findElement(By.cssSelector("a[title=\"40-45\"]")).isSelected());


        for (int i = 0; i < 4; i++) {
            driver.findElement(By.cssSelector("i.icon-plus")).click();
        }

        //Verify the title of the item contains expected:
        //Expected: "Çorap Siyah"
        String expectedWordInItemTitle = "Çorap Siyah";
        String actualItemTitle = driver.findElement(By.cssSelector("h1.product-name.js-name")).getText();

        if (actualItemTitle.contains(expectedWordInItemTitle))
            System.out.println("Item title test is PASSED!");
        else
            System.out.println("Item title test is FAILED!");

        driver.findElement(By.cssSelector("i.icon-sepetekle")).click();
        //Go to cart
        driver.findElement(By.cssSelector("a.go-to-shop")).click();

        //Find the search box
        WebElement searchBox = driver.findElement(By.xpath("(//input[@name=\"search_text\"])[1]"));
        //Search for item
        searchBox.sendKeys("Albeni");
        driver.findElement(By.xpath("//button[@type=\"submit\" and em[@class=\"input-icon icon-search\"]]")).click();
        //Add new items to the cart
        driver.findElement(By.xpath("//div[@data-pk=\"1558\"]")).click();
        //Go to the cart
        driver.findElement(By.xpath("//a[@href=\"/baskets/basket/\" and @title=\"Sepet\" and @class=\"js-header-basket-toggle\"]")).click();
        //Go to the payment page
        driver.findElement(By.xpath("//a[@title=\"Sepeti Onayla\" and @href=\"/orders/checkout/\"]")).click();
        //Continue without sign up
        driver.findElement(By.xpath("//a[@title=\"ÜYE OLMADAN DEVAM ET\"]")).click();
        //Write your mail address to the pup up box
        driver.findElement(By.xpath("//input[@name=\"user_email\"]")).sendKeys("Enough for practice!");

    }

/*    @Test//Test all links
    public void testAllLinksOnTheMainPage() {
        driver.get("https://www.a101.com.tr/");
        ReusableMethods.verifyPageTitle(driver, "Cydeo");

        testAllLinksOnTheHomepage();

    }*/
}
