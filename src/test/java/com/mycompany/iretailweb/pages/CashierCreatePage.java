/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.Cashier;
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

public class CashierCreatePage extends PageObject{
    
//*** Page elements ***
    
// Поле "Фамилия" - обязательное для заполнения
    @FindBy(xpath = "//input[@ng-model='vm.employee.last_name']")
    private WebElementFacade input_cashier_last_name;
// Поле "Имя" - обязательное для заполнения
    @FindBy(xpath = "//input[@ng-model='vm.employee.first_name']")
    private WebElementFacade input_cashier_first_name;
    
// Мультиселект "Место работы" - обязателен для заполнения
   

// галочка вся компания
    @FindBy(xpath = "//input[@ng-model='vm.employee.is_work_in_all_channel']")
    private WebElementFacade input_cashier_work_all_channels;

// Поле "E-mail" - обязательное для заполнения
    @FindBy(xpath = "//input[@ng-model='vm.employee.email']")
    private WebElementFacade input_cashier_email;
// Поле "Телефон" - обязательное для заполнения
    @FindBy(xpath = "//input[@ng-model='vm.employee.phone']")
    private WebElementFacade input_cashier_phone;

// Поле "Пин код от кассы" - обязательное для заполнения 
    @FindBy(xpath = "//input[@ng-model='vm.employee.pin']")
    private WebElementFacade input_cashier_pin;
    
// Кнопка "Сгенерировать пин-код" - используем когда не важно какой пинкод
 @FindBy(xpath = "//button[@ng-click='vm.generatePin()']")
    private WebElementFacade btn_generate_pin;

// Кнопка "Создать"
    @FindBy(xpath = "//buttons-employee[@class='ng-isolate-scope']//button")
    private WebElementFacade btn_add_cashier;
    
// Кнопка "Да" модального окна "Вы уверены, что хотите создать торговую точку"
    @FindBy (xpath = "//div[contains(@class, 'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes;
    
//* Кнопка "Ok" модального окна "Торговая точка успешно создана"
    @FindBy (xpath = "//div[contains(@style,'display: block')]//div[contains(@class,'submit')]")
    private WebElementFacade btn_ok;
    
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;
    
         
//*** Methods ***

// Вводим фамилию сотрудника
    public void enterCashierLastName(Cashier cashier) {
        try { 
            waitForLoad();
            input_cashier_last_name.waitForCondition();
            input_cashier_last_name.type(cashier.getLast_name());
        } catch (Exception e) {
            System.err.println("Не удалось ввести фамилию сотрудника " +e.getMessage());
        }
    }
    
    
// Вводим имя сотрудника
    public void enterCashierFirstName(Cashier cashier) {
        try { 
            input_cashier_first_name.waitForCondition();
            input_cashier_first_name.type(cashier.getFirst_name());
        } catch (Exception e) {
            System.err.println("Не удалось ввести имя сотрудника " +e.getMessage());
        }
    }
    
    //Отмечаем что сотрудник работает во всей компании
    public void clickCashierWorksInAllChannels() {
        try { 
            input_cashier_work_all_channels.waitForCondition();
            input_cashier_work_all_channels.click();
        } catch (Exception e) {
            System.err.println("Не удалось выбрать что сотрудник работает во всей компании " +e.getMessage());
        }
    }
    // Вводим почту сотрудника
    public void enterCashierEmail(Cashier cashier) {
        try { 
            input_cashier_email.waitForCondition();
            input_cashier_email.type(cashier.getEmail());
        } catch (Exception e) {
            System.err.println("Не удалось ввести почту сотрудника " +e.getMessage());
        }
    }
    
        // Вводим телефон сотрудника
    public void enterCashierPhone(Cashier cashier) {
        try { 
            input_cashier_phone.waitForCondition();
            input_cashier_phone.type(cashier.getPhone());
        } catch (Exception e) {
            System.err.println("Не удалось ввести телефон сотрудника " +e.getMessage());
        }
    }

//Жмём кнопку сгенерировать пинкод
    public void clickBtnGeneratePin() {
        try {
            waitForLoad();
            btn_generate_pin.waitForCondition();
            btn_generate_pin.click();
        } catch (Exception e) {
             System.err.println("Не удалось сгенерировать пин-код " +e.getMessage());
        }
    }

// Жмем кнопку "Создать"
    public void clickBtnAddСashier() {
        try {
            waitForLoad();
            btn_add_cashier.waitForCondition();
            btn_add_cashier.click();
        } catch (Exception e) {
             System.err.println("Не удалось сохранить сотрудника " +e.getMessage());
        }
        
    }
    
// * Жмем кнопку "Да" модального окна подтверждения создания сотрудника
    public void clickBtnYes() throws InterruptedException {
        try {
            waitForLoad();
            btn_yes.waitForCondition();
            btn_yes.click();
        } catch (Exception e) {
            System.err.println("Не удалось подтвердить сохранение сотрудника " +e.getMessage());
            
        }
    }

// * Жмем кнопку "Ok" модального окна "Торговая точка успешно создана"
    public void clickBtnOk() throws InterruptedException {
        try {
            waitForLoad();
            btn_ok.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка Ok модального окна Сотрудник добавлен");
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

