package com.cydeo.utilities;

import java.io.*;
import java.util.*;

public class ConfigurationReader {

    //1- Create the object of Properties. By private keyword we will see it only in this class. By using static, we will be able to call it with class name
    private static Properties properties = new Properties();

    static{//Running first and running only once at the beginning

        try {

            //2- We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- Load the properties object using FileInputStream object
            properties.load(file);

            //close the file
            file.close();


        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}