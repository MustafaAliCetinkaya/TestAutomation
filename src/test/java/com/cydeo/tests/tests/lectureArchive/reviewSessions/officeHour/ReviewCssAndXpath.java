package com.cydeo.tests.tests.lectureArchive.reviewSessions.officeHour;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.concurrent.TimeUnit;

public class ReviewCssAndXpath {
    // why findElements() is returning empty list if no match?
    // because when we call the method, it will creat an empty list first,
    // then to find the web elements. if there are no matches, then the list
    // will be keep empty.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*
        1. Css locator
          tagName[attributeName='value']
          tagName#idValue    or tagName.classValue

          div[type='text']     li.list-group-item:nth-of-type(1)
          div#radio   using id value
          div.radio   using class value

          use > sign to go from parent to child
          div.radio > h1   first way is using >
          div.radio h1     second way is using a space

          nth-of-type(index number)

          2, xpath locator

          1) absolute xpath -- start from the first element (which is html)
          then go to your element step by step
           start with /, continue with /


           2) relative xpath -- start wherever you want
           start with //, continue with //, when want to child element, then use /

           //li[@class='list-group-item']


            frequently used syntax for xpath

            //tagName[@attribute='value’]
            //tagName[contains(@attribute, 'value’)]
            //tagName[.='text'] (same as //tagName[text()='text’], . represents text)
            //*[@attribute='value’] ( use * when we don't want use tag name)


            go from parent to child
            we use / to go from parent to child
            //tagName[@attribute='value']/tagName

            we also can go from child to parent using /..
            childElement/..    //li[@class='list-group-item']/..


            we can go between siblings using /preceding  or following siblings method
            following-sibling::tagName
            preceding-sibling::tagName
         */

    }
}