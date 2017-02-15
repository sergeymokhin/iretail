/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

/**
 *
 * @author igorg
 */
public class Device {
    private String name;
    private String tradepoint;
    private String scenario;
    private Boolean ownorders;
    private Boolean fiscalmode;
    private String shiftnumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradepoint() {
        return tradepoint;
    }

    public void setTradepoint(String tradepoint) {
        this.tradepoint = tradepoint;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public Boolean getOwnorders() {
        return ownorders;
    }

    public void setOwnorders(Boolean ownorders) {
        this.ownorders = ownorders;
    }

    public Boolean getFiscalmode() {
        return fiscalmode;
    }

    public void setFiscalmode(Boolean fiscalmode) {
        this.fiscalmode = fiscalmode;
    }

    public String getShiftnumber() {
        return shiftnumber;
    }

    public void setShiftnumber(String shiftnumber) {
        this.shiftnumber = shiftnumber;
    }
    
    public static Device generateNewDevice() { 
        Device device = new Device();
        device.name = DataGeneration.generateRandomString(10); //!!! а геттеры сеттеры зачем тогда?
        return device;
    }
    
}
