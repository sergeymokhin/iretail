/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

/**
 *
 * @author i.gross@freematiq.com
 */
public class TradePoint {
    private String name = "";
    private String country = "";
    private String city = "";
    private String street = "";
    private String building = "";
    
    public static TradePoint generateNewTradePoint(){
        TradePoint tradePoint = new TradePoint();
        tradePoint.name = DataGeneration.generateRandomString(10);
        tradePoint.city = DataGeneration.generateRandomString(10);
        tradePoint.street = DataGeneration.generateRandomString(10);
        tradePoint.building = DataGeneration.generateRandomNumber(2)+DataGeneration.generateRandomString(1);
        return tradePoint;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }
    
}
