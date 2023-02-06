package com.cydeo.tests.tests.lectureArchive.day9_10_JavaFakerTestBaseDriverUtil;

import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JavaFaker extends TestBase {
    @Test
    public void fakerTest(){
        Faker faker=new Faker();
        Actions action=new Actions(driver);

        driver.get("http://automationexercise.com");
        //3. Click on 'Signup / Login' button
        WebElement signupElement=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        action.click(signupElement).perform();

        //4. Enter name and email address
        //5. Click 'Signup' button
        WebElement nameBox= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        action.click(nameBox)
                .sendKeys( faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().safeEmailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //6. Fill details: Title, Name, Email, Password, Date of birth
        //7. Select checkbox 'Sign up for our newsletter!'
        //8. Select checkbox 'Receive special offers from our partners!'
        //9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement titleRadiButton= driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        action.click(titleRadiButton);//Mr.
        action.sendKeys(Keys.TAB);
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.internet().password(8, 16));
        action.sendKeys(Keys.TAB);
        action.sendKeys(""+faker.number().numberBetween(1, 31));
        action.sendKeys(Keys.TAB);
        action.sendKeys("April");
        action.sendKeys(Keys.TAB);
        action.sendKeys(""+faker.number().numberBetween(1900, 2021));
        action.sendKeys(Keys.TAB);
        action.click();
        action.sendKeys(Keys.TAB);
        action.click();
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.name().firstName());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.name().lastName());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.company().name());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.address().fullAddress());
        action.sendKeys(Keys.TAB);
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.address().country());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.address().state());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.address().city());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.address().zipCode());
        action.sendKeys(Keys.TAB);
        action.sendKeys(faker.phoneNumber().cellPhone());
        action.sendKeys(Keys.TAB);
        action.sendKeys(Keys.ENTER);
        action.perform();


    }
}
