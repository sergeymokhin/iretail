/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author igorg
 */
//*** Methods ***
@DefaultUrl("/main/sales-channels/trade-point")

public class TradePointPage extends PageObject{
    
   
      
     @FindBy (xpath = "(//div[@class='required ng-scope']//*[@translate])[1]")
     //(//div[@class='required ng-scope']//*[@translate])[1]/text()    не получилось вытащить текст напрямую (null)
      private WebElementFacade first_trade_point_link; //решил взять весь элемент
     
     
       public String getFirstTradePointName() throws InterruptedException {
        try {
            return  first_trade_point_link.getAttribute("translate");
        } catch (Exception e) {
            System.out.println("Не удалось найти первую компанию в списке" + e.getMessage());
                return null;    
        }
    }
    

    
}
