/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

import java.math.BigDecimal;

/**
 *
 * @author igorg
 */
public class Offer {
   private String name;
   private Category category;
   private String article;
   private String barcode;
   private String link;
   private BigDecimal baseprice;
   private BigDecimal price;
   private String description;
    
    public static Offer generateNewOffer(){
        Offer offer = new Offer();
        offer.name = DataGeneration.generateRandomString(10);
        offer.article = DataGeneration.generateRandomString(6);
        offer.barcode = DataGeneration.generateRandomNumber(13);
        offer.link = DataGeneration.generateRandomLink();
        offer.baseprice = DataGeneration.generateRandomPrice();
        return offer;
       
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getArticle() {
        return article;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getLink() {
        return link;
    }

    public BigDecimal getBaseprice() {
        return baseprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setBaseprice(BigDecimal baseprice) {
        this.baseprice = baseprice;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
   
    
    
}
