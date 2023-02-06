package com.cydeo.lectureArchive.day8_PropertiesConfigReader;

import org.testng.annotations.*;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){
        //key = value
        //os.name = Mac OS X
        //user.name = cybertekchicago-1
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

    }

}