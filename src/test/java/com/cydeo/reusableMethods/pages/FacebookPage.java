package com.cydeo.reusableMethods.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cydeo.reusableMethods.base.TestBaseBeforeClassAfterClass.*;

public interface FacebookPage {

    public static void facebookLogin() {
        for (int i = 0; i < 100; i++) {
            WebElement inputUsername = driver.findElement(By.cssSelector("input#email"));
            WebElement inputPassword = driver.findElement(By.cssSelector("input#pass"));
            WebElement loginButton = driver.findElement(By.xpath("//button[.=\"Giriş Yap\"]"));

            inputUsername.clear();
            inputUsername.sendKeys(faker.internet().safeEmailAddress());
            inputPassword.sendKeys(faker.internet().password());
            actions.click(loginButton).perform();
        }
    }

    default void facebookLogin(String username, String password) {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.cssSelector("input#email"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.cssSelector("input#pass"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//button[.=\"Giriş Yap\"]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div._9ay7"));
        System.out.println(errorMessage.getText());
    }
}
