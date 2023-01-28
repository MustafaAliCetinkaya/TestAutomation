package com.cydeo.testNG.practices.pages.automationExercise.testCase1;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/*Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/
public class RegisterUser {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://automationexercise.com");

        String expectedTitle = "Automation Exercise";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible successfully.");

        }

        driver.findElement(By.cssSelector("i.fa.fa-lock")).click();

        WebElement newUserSignup = driver.findElement(By.xpath("(//h2)[3]"));
        newUserSignup.isDisplayed();
        if (newUserSignup.getText().equals("New User Signup!")) {
            System.out.println("New User Signup! is visible");
        } else {
            System.out.println("New User Signup! is not visible");

        }

        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        WebElement nameBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        actions.click(nameBox)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement enterAccountInfo = driver.findElement(By.xpath("(//h2)[1]"));
        enterAccountInfo.isDisplayed();

        WebElement genderRadioButton = driver.findElement(By.cssSelector("input#id_gender1"));
        actions.click(genderRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("" + faker.number().numberBetween(1, 31))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("" + faker.number().numberBetween(1900, 2021))
                .sendKeys(Keys.TAB).pause(2000)
                .click()
                .sendKeys(Keys.TAB).pause(2000)
                .click()
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).pause(2000)
                .sendKeys(Keys.ENTER)
                .perform();


    }
}
