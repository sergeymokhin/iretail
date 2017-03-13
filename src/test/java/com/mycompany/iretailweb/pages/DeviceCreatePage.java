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
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.OutputType;

/**
 *
 * @author igorg
 */
//*** Methods ***
@DefaultUrl("/main/catalog/offers/create")

public class DeviceCreatePage extends PageObject {

    //Находим поле Название
    @FindBy(xpath = "//input[@ng-model='vm.data.name']")
    private WebElementFacade input_device_name;

    //Находим селект Торговая точка
    @FindBy(xpath = "//select[@ng-model='vm.data.channelId']")
    private WebElementFacade select_device_tradepoint;

    //Находим селект Сценарий работы
    @FindBy(xpath = "//select[@ng-model='vm.data.currentType']")
    private WebElementFacade select_device_scenario;

    // Находим чекбокс "Отображать заказы только этой кассы" 
    @FindBy(xpath = "//input[@ng-model='vm.data.own_orders']")
    private WebElementFacade checkbox_device_ownorders;
    
    // Находим чекбокс "Фискальный режим кассы" 
    @FindBy(xpath = "//input[@ng-model='vm.data.fiscal_mode']")
    private WebElementFacade checkbox_device_fiscalmode;

    // Находим поле "Номер смены"
    @FindBy(xpath = "//input[@ng-model='vm.data.shiftNumber']")
    private WebElementFacade input_device_shiftnumber;

    // Находим кнопку "Добавить"
    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade btn_add_device;
    
    // Кнопка "Да" модального окна подтверждения создания кассы
    @FindBy(xpath = "//div[@class='jBox-Confirm-button jBox-Confirm-button-submit']")
    private WebElementFacade btn_ok;
     
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;

    public void enterDeviceName(Device device) {
        try {
            waitForLoad();
         //   input_device_name.waitForCondition();
            input_device_name.waitUntilClickable();
            input_device_name.type(device.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название кассы " + e.getMessage());
        }

    }

    public void clickBtnSaveDevice() {
        try {
            waitForLoad();
            btn_add_device.waitUntilClickable();
            btn_add_device.click();
        } catch (Exception e) {
        }

    }

    // * Жмем кнопку "Ок" в оповещении о создании товара.
    public void clickBtnOk() throws InterruptedException {
        try {
            waitForLoad();
            btn_ok.waitUntilVisible();
            btn_ok.waitUntilClickable();
            btn_ok.click();
        } catch (Exception e) {
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
