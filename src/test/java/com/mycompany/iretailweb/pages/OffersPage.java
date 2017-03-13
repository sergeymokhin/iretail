/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.Offer;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author igorg
 */
//*** Methods ***
@DefaultUrl("/main/catalog/offers")

public class OffersPage extends PageObject {

    //Находим поле Название
    @FindBy(xpath = "//input[@ng-model='vm.filter.name']")
    private WebElementFacade input_offer_name;

    // Кнопка "Найти" 
    @FindBy(xpath = "//span[@translate='common.search']")
    private WebElementFacade btn_search;
    
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;

    public void enterOfferName(Offer offer) {
        try {
            waitForLoad();
            input_offer_name.waitForCondition();
            input_offer_name.type(offer.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название товара " + e.getMessage());
        }
    }

    public void clickBtnSearch() {
        try {
            waitForLoad();
            btn_search.waitForCondition();
            btn_search.click();
        } catch (Exception e) {
            System.err.println("Не удалось восполльзоваться поиском товара " + e.getMessage());
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
