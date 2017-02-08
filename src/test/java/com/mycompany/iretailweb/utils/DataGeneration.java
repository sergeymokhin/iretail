/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author SergeyTest
 */
public class DataGeneration {
    
// Два Юриных метода, для генерации последовательности букв или цифр заданной длины    

    public static String generateRandomString(int length) 
    {
        String key = RandomStringUtils.randomAlphabetic(length);
        return key;
    }
     public static String generateRandomNumber(int length) 
    {
        String key = RandomStringUtils.randomNumeric(length);
        return key;
    }
     
    public static String generateRandomLink() {
        String link = "https://" + RandomStringUtils.randomAlphanumeric(10) +"."+RandomStringUtils.randomAlphanumeric(10)+ ".com";
        return link;
    }
    
    public static BigDecimal generateRandomPrice(){
    Random random = new Random();
    BigDecimal bdvalue = new BigDecimal(random.nextDouble()*1000);
    bdvalue = bdvalue.setScale(2,BigDecimal.ROUND_HALF_UP);
    return bdvalue;
    }
}
