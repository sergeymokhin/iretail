/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 *
 * @author SergeyTest
 */
@DefaultUrl("/main")

public class MainPage extends PageObject {

//*** Page elements ***
// Кнопка "Добавить Компанию" присутствует на странице в двух местах:
// 1. Если это первая компания пользователя, то кнопку видно на странице, 
// она самая верхняя в разделе "С чего начать?"  
// 2. Если это не первая компания пользователя, то кнопка спрятана в выпадающем списке
// Поэтому переход на страницу создания компании реализован по прямому переходу
// по ссылке на /main/create-profile без нажатия на кнопку
//* Кнопка "Добавить торговую точку" *
    @FindBy(xpath = "//span[@translate='home.addTradePoint']/parent::*")
    private WebElementFacade btn_add_trade_point;

//* Кнопка "Загрузить каталог из файла" *
//* Кнопка "Создать категории" *  
    @FindBy(xpath = "//span[@translate='home.addCategories']/parent::*")
    private WebElementFacade btn_add_category;

//* Кнопка "Добавить товары" *
//* Кнопка "Добавить сотрудников" *    
//*** Methods ***
// * Жмем кнопку "Добавить торговую точку" *    
    public void clickBtnAddTradePoint() {
        btn_add_trade_point.waitUntilClickable();
        // System.out.println("-----------------------------------"+btn_add_trade_point.getAttribute("text")); 
        btn_add_trade_point.click();
    }

    // * Жмем кнопку "Создать категории" *    
    public void clickBtnAddCategory() {
        btn_add_category.waitUntilClickable();
        //System.out.println("-----------------------------------"+btn_add_trade_point.getAttribute("text")); 
        btn_add_category.click();
    }

}
