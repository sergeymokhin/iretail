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
        try {
            waitForLoad(); //экспериментального ожидание, если проканает добавим везде ВРОДЕ РАБОТАЕТ КРУТАЯ ТЕМА !!! а науя 2 раза ожидание одно и то же?
            device_tab.waitUntilPresent();
            device_tab.waitForCondition();
            device_tab.click();
        } catch (Exception e) {
            System.err.println("Не удалось перейти на вкладку касс "+e.getMessage());
        }

    }

    public void enterDeviceNameInFilter(Device device) {
        try {
            waitForLoad();
            input_device_name.waitForCondition();
            input_device_name.type(device.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название кассы в фильтр " + e.getMessage());
        }
    }

    public void clickBtnSearch() {
        try {
            btn_search.waitForCondition();
            btn_search.waitUntilClickable();
            btn_search.click();
        } catch (Exception e) {
            System.err.println("Не удалось нажать кнопку Найти" + e.getMessage());
        }

    }

    public void clickBtnAddDevice() throws InterruptedException {
        try {
            waitForLoad();
            btn_add_device.waitUntilPresent();
            btn_add_device.click();
        } catch (Exception e) {
            System.err.println("Не удалось нажать кнопку Добавить кассу");
        }

    }
    
     public void waitForLoad() {
        try {
        loader.waitUntilVisible();
        loader.waitUntilNotVisible();
        } catch (Exception e) {
            System.err.println("Нет отображается лоадер ещё(уже)");
        }
}
}
