package com.cydeo.reusableMethods.pages;

import com.cydeo.reusableMethods.methods.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static com.cydeo.reusableMethods.base.TestBaseBeforeClassAfterClass.driver;
import static com.cydeo.reusableMethods.base.TestBaseBeforeClassAfterClass.faker;

public interface FacebookPage {

    public static void facebookLogin() {
        for (int i = 0; i < 100; i++) {
            ReusableMethods.waitFor(5);
            driver.findElement(By.cssSelector("input#email")).clear();
            driver.findElement(By.cssSelector("input#email")).sendKeys(faker.internet().safeEmailAddress());
            driver.findElement(By.cssSelector("input#pass")).sendKeys(faker.internet().password());
            driver.findElement(By.xpath("//button[.=\"Giriş Yap\"]")).click();
        }
    }

    default void facebookLogin(String username, String password) {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.cssSelector("input#email"));
        System.out.println(inputUsername.getAttribute("placeholder"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.cssSelector("input#pass"));
        System.out.println(inputPassword.getAttribute("placeholder"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//button[.=\"Giriş Yap\"]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div#error_box"));
        System.out.println(errorMessage.getText());
    }

    public static String getMockEmailAndPassword() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

        String temp="";
        Random random = new Random();

        while (temp.length() < 10) { // length of the random string.
            int index = random.nextInt(39);
            temp+=allowedChars.charAt(index);
        }

        String loginInfo = temp.toString();
        return loginInfo;

    }
}
