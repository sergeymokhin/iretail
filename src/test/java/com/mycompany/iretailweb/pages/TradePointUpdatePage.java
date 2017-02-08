/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.Device;
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
    
    @FindBy(xpath = "//input[@ng-model='vm.filter.name']")// поле название в фильтре касс
    private WebElementFacade input_device_name;
  
    @FindBy(xpath = "//span[@translate='common.search']") //кнопка найти
    private WebElementFacade btn_search;

    public void clickDeviceTab() throws InterruptedException {
        loader.waitUntilNotVisible();
        try {
            loader.waitUntilNotVisible(); //экспериментального ожидание, если проканает добавим везде ВРОДЕ РАБОТАЕТ КРУТАЯ ТЕМА
            device_tab.click();
        } catch (Exception e) {
            System.err.println("Не удалось перейти на вкладку касс"+e.getMessage());
        }

    }

    public void enterDeviceNameOnFilter(Device device) {
        try {
            loader.waitUntilNotVisible();
            input_device_name.type(device.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название кассы в фильтр " + e.getMessage());
        }
    }
     public void clickBtnSearch() {
        loader.waitUntilNotVisible();
        btn_search.click();
    }
    
    
    
    public void clickBtnAddDevice() throws InterruptedException {
        loader.waitUntilNotVisible();
        btn_add_device.click();
    }
}