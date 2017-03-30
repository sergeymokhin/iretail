/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.Cashier;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author SergeyTest
 */

@DefaultUrl("/main/sales-channels/trade-point/create")

public class CashierPage extends PageObject{
    
//*** Page elements ***
    
// Поле фильтра "ФИО"
    @FindBy(xpath = "//input[@ng-model='vm.filter.name']")
    private WebElementFacade input_cashier_name;
// Кнопка Найти
    @FindBy(xpath = "//span[@translate='common.search']")
    private WebElementFacade btn_search;
    
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;

    
         
//*** Methods ***

// Вводим фамилию сотрудника
    public void enterCashierName(Cashier cashier) {
        try { 
            waitForLoad();
            input_cashier_name.waitForCondition();//!!! опять не понятно чего ждем
            input_cashier_name.type(cashier.getLast_name());
        } catch (Exception e) {
            System.err.println("Не удалось ввести фамилию сотрудника в поиск" +e.getMessage());
        }
    }

// * Жмем кнопку Найти
    public void clickBtnSearch() throws InterruptedException {
        try {
            waitForLoad();
            btn_search.click();
        } catch (Exception e) {
            System.out.println("Не удалось нажать кнопку Найти");
        }
        
    }
    public void waitForLoad() {
        try {
        loader.waitUntilVisible();
        loader.waitUntilNotVisible();
        } catch (Exception e) {
            System.err.println("Идёт ожидание загрузки страницы...");
        }
}    

    
}

