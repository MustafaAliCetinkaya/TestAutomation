package com.cydeo.tests.tests.lectureArchive.testNG.practices.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferenceBetweenAssertAndVerifySoftAssertion {
    @Test
    public void assertVsSoftAssert1(){
        Assert.assertTrue(true);
        System.out.println("Line 10");
        Assert.assertTrue(true);
        System.out.println("Line 12");
        Assert.assertTrue(false);//codes after that fragment won't work
        System.out.println("Line 14");
    }
    @Test
    public void assertVsSoftAssert2(){//This is verify (soft assert). Not a common practice
        SoftAssert softAssert=new SoftAssert();//Firstly create and soft assert object.

        softAssert.assertTrue(true);
        System.out.println("Line 10");
        softAssert.assertTrue(true);
        System.out.println("Line 12");
        softAssert.assertTrue(false);//codes after that fragment will work
        System.out.println("Line 14");

        softAssert.assertAll();//Behaves as a normal assertion. Codes after that fragment won't work
        System.out.println("Line 29");
        //Advantage: It will compile every code then shows the all problems. You can see the failures together after run the remains.
    }
}
