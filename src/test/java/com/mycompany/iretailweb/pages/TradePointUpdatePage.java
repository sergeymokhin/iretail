/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 *
 * @author igorg
 */
//*** Methods ***
//@DefaultUrl()
public class TradePointUpdatePage extends PageObject {

    @FindBy(xpath = "//p[@translate='tradePoint.list.actions.devices']")
    private WebElementFacade device_tab; //вкладка кассы

    @FindBy(xpath = "//button[@ui-sref='.createDevice']")
    private WebElementFacade btn_add_device; //кнопка добавить кассу
    
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;

    public void clickDeviceTab() throws InterruptedException {
        
        try {
            loader.waitUntilNotVisible(); //экспериментального ожидание, если проканает добавим везде ВРОДЕ РАБОТАЕТ КРУТАЯ ТЕМА
            //device_tab.waitUntilClickable();
            device_tab.click();
        } catch (Exception e) {
            System.err.println("Не удалось перейти на вкладку касс"+e.getMessage());
        }

    }

    public void clickBtnAddDevice() throws InterruptedException {
        loader.waitUntilNotVisible();
       // btn_add_device.waitUntilClickable();
        btn_add_device.click();
    }
}
