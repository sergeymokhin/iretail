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
    public String name = "";
    public String country = "";
    public String city = "";
    public String street = "";
    public String building = "";
    
    public static TradePoint generateNewTradePoint(){
        TradePoint tradePoint = new TradePoint();
        tradePoint.name = DataGeneration.generateRandomString(10);
        tradePoint.city = DataGeneration.generateRandomString(10);
        tradePoint.street = DataGeneration.generateRandomString(10);
        tradePoint.building = DataGeneration.generateRandomNumber(2)+DataGeneration.generateRandomString(1);
        return tradePoint;
    }
}
