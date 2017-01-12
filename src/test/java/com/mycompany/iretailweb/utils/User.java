/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

/**
 *
 * @author Zver
 */
public class User {
    public String name = "";
    public String email = "";
    public String phone = "";
    public String password = "";
    
    public static User createNewUser(){
        User user = new User();
        user.name = DataGeneration.generateRandomString(6);
        user.email = DataGeneration.generateRandomString(6)+"@"+DataGeneration.generateRandomString(4)+".ru";
        user.phone = Const.beelinePrefix+DataGeneration.generateRandomNumber(7);
        user.password = DataGeneration.generateRandomString(8);
        return user;
    }
}
