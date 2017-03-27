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
public class Cashier {
    private String first_name; //Имя
    private String last_name; //Фамилия
    private String phone;
    private String email;
    private String pin;
    private Boolean all_channels;

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setAll_channels(Boolean all_channels) {
        this.all_channels = all_channels;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPin() {
        return pin;
    }

    public Boolean getAll_channels() {
        return all_channels;
    }
    
    public  static Cashier createNewCashier(){
        Cashier cashier = new Cashier();
        cashier.setLast_name(DataGeneration.generateRandomString(10));
        cashier.setFirst_name(DataGeneration.generateRandomString(10));
        cashier.setPhone(DataGeneration.generateRandomPhone());
        cashier.setEmail(DataGeneration.generateRandomEmail());
        return cashier;
    }

   
    

    
    
}
