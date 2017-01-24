/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.DataGeneration;
import com.mycompany.iretailweb.utils.TradePoint;
import java.util.Random;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author SergeyTest
 */

@DefaultUrl("/main/sales-channels/trade-point/create")

public class TradePointCreatePage extends PageObject{
    
//*** Page elements ***
    
// Поле "Название" - обязательное для заполнения
    @FindBy(xpath = "//label[@translate='tradePoint.create.title']/parent::*/input")
    private WebElementFacade input_trade_point_name;
               
// Поле "ИНН" 
    
// Поле "КПП"
    
// Мультиселект "Страна" - обязателен для заполнения
// @FindBy(xpath = "//label[@translate='tradePoint.create.country']/parent::*/select")
// Завязываемся на ангуляровский атрибут
    @FindBy(xpath = "//select[@ng-model='vm.tradePoint.address.country']")
    private WebElementFacade select_trade_point_country;
    
// Поле "Регион"
    
// Поле "Город" - обязательное для заполнения
    @FindBy(xpath = "//input[@ng-model='vm.tradePoint.address.city']")
    private WebElementFacade input_trade_point_city;

// Поле "Улица" - обязательное для заполнения 
    @FindBy(xpath = "//input[@ng-model='vm.tradePoint.address.street']")
    private WebElementFacade input_trade_point_street;
    
// Поле "Номер дома" - обязательное для заполнения 
    @FindBy(xpath = "//input[@ng-model='vm.tradePoint.address.building']")
    private WebElementFacade input_trade_point_building;
    
// Поле "Офис/квартира"
    
// Кнопка "Добавить торговую точку" - становится активной, когда заполнены все обязательные поля
    @FindBy(xpath = "//button[@type='submit'][not(@disabled)]")
    private WebElementFacade btn_add_trade_point;
    
// Кнопка "Да" модального окна "Вы уверены, что хотите создать торговую точку"
    @FindBy (xpath = "//div[contains(@class, 'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes;
    
//* Кнопка "Ok" модального окна "Торговая точка успешно создана"
    @FindBy (xpath = "//div[@class='jBox-Confirm-button jBox-Confirm-button-submit']")
    private WebElementFacade btn_ok;
    
         
//*** Methods ***

// Вводим название торговой точки в поле "Название"
    public void enterTradePointName(TradePoint tradePoint) {
        try {  
            input_trade_point_name.type(tradePoint.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название торговой точки " +e.getMessage());
        }
    }

// Рандомно выбираем страну, в которой находится наша торговая точка 
// из выпадающего списка стран
    public void selectTradePointCountry(TradePoint tradePoint) {
        Select droplist = new Select(select_trade_point_country);
        Random randomno = new Random();
        droplist.selectByValue(String.valueOf(randomno.nextInt(250)));
        try {
           tradePoint.setName(droplist.getFirstSelectedOption().getText());
        } catch (Exception e) {
            System.err.println("Не удалось получить выбранную страну " +e.getMessage() );
        }
        
       
//        tradePoint.country = droplist.getAllSelectedOptions().get(1).getText();  //выяснить как вытащить из селекта текст
    }

// Вводим город торговой точки в поле "Город"
    public void enterTradePointCity(TradePoint tradePoint) {
         try {  
            input_trade_point_city.type(tradePoint.getCity());
        } catch (Exception e) {
            System.err.println("Не удалось ввести город " +e.getMessage());
        }
    }
    
// Вводим улицу торговой точки в поле "Улица"
    public void enterTradePointStreet(TradePoint tradePoint) {
         try { 
               input_trade_point_street.type(tradePoint.getStreet());
        } catch (Exception e) {
            System.err.println("Не удалось ввести улицу " +e.getMessage());
        }
    }
    
// Вводим номер дома торговой точки в поле "Номер дома"
    public void enterTradePointBuilding(TradePoint tradePoint) {
         try { 
             input_trade_point_building.type(tradePoint.getBuilding());
        } catch (Exception e) {
            System.err.println("Не удалось ввести номер дома " +e.getMessage());
        }
    }    

// Жмем кнопку "Добавить торговую точку"
    public void clickBtnAddTradePoint() {
        btn_add_trade_point.click();
    }
    
// * Жмем кнопку "Да" модального окна подтверждения создания торговой точки
    public void clickBtnYes() throws InterruptedException {
        btn_yes.click();
    }

// * Жмем кнопку "Ok" модального окна "Торговая точка успешно создана"
    public void clickBtnOk() throws InterruptedException {
        Thread.sleep(2000);
        try {
            btn_ok.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка Ok модального окна Торговая точка успешно создана");
        }
        
    }    

    
}

