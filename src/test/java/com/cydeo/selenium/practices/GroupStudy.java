package com.cydeo.selenium.practices;

import org.testng.annotations.*;

public class GroupStudy {

    @BeforeClass

    public void beforeClass(){
        System.out.println("This is before class method. It will run only once");
    }

    @AfterClass

    public void afterClass(){
        System.out.println("This is after class method. It will run only once");
    }

    @BeforeMethod

    public void beforeMethod(){
        System.out.println("This is before method. It will run many times.");
    }

    @AfterMethod

    public void afterMethod(){
        System.out.println("This is after method. It will run many times.");
    }

    @Test
    public void test1(){
        System.out.println("This is test1");
    }

    @Test
    public void test2(){
        System.out.println("This is test2");
    }


}
