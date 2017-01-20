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
public class Offer {
   public String name;
   public Category category;
   public String artikul;
   public String barcode;
   public String link;
   public Double baseprice;
   public Float price;
   public String description;
    
    public static Offer generateNewOffer(){
        Offer offer = new Offer();
        offer.name = DataGeneration.generateRandomString(10);
        offer.artikul = DataGeneration.generateRandomString(6);
        offer.barcode = DataGeneration.generateRandomNumber(13);
        offer.link = DataGeneration.generateRandomLink();
        offer.baseprice = DataGeneration.generateRandomDouble();
        return offer;
       
    }
    
   
    
    
}
