/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

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
     
// Более не используемые старые методы для генерации  последовательности букв или цифр заданной длины
     
//    private static final String ENG_SMALL = "abcdefghijklmnopqrstuvwxyz"; //26
//    private static final String NUMS = "0123456789"; //10
////    private static final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //26
////    private static final String symb = "!@#$%^&*"; //8 - на будущее    
//
////метод, генерирующий случайную строку заданного размера + язык(в перспективе):    
//    public static String randomString(int count) {
//        StringBuilder randString = new StringBuilder();    
//        for(int i = 0; i < count; i++) {
//            Random randomnumber = new Random();
//            randString.append(ENG_SMALL.charAt(randomnumber.nextInt(ENG_SMALL.length())));
//        }
//        System.out.println("Сгенерировалась строка "+randString.toString());
//        return randString.toString(); 
//       }
//
////метод, генерирующий заданное количество случайных цифр   
//    public static String randomPhone(int count) {
//        StringBuilder randNum = new StringBuilder();
//        for(int i = 0; i < count; i++) {
//            Random numbers = new Random();
//            randNum.append(NUMS.charAt(numbers.nextInt(NUMS.length())));
//        }
//        System.out.println("Сгенерировалась строка из цифр "+randNum.toString());
//        return randNum.toString();         
//    }     
}
