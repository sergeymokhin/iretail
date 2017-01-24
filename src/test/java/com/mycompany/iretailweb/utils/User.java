/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

import java.util.logging.Logger;

/**
 *
 * @author Zver
 */
public class User {
    private String name = "";
    private String email = "";
    private String phone = "";
    private String password = "";
    
    public  User createNewUser(){
        User user = new User();
        user.name = DataGeneration.generateRandomString(6);
        user.email = DataGeneration.generateRandomString(6)+"@"+DataGeneration.generateRandomString(4)+".ru";
        user.phone = Const.beelinePrefix+DataGeneration.generateRandomNumber(7);
        user.password = DataGeneration.generateRandomString(8);
        return user;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return Const.userPhone;
    }

    public String getPassword() {
        return Const.userPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    
    
}
