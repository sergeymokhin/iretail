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

    public void enterOfferName(Offer offer) {
        try {
            input_offer_name.waitUntilVisible();
            input_offer_name.type(offer.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название товара " + e.getMessage());
        }

    }

    public void clickBtnSearch() {
        btn_search.waitUntilClickable();
        btn_search.click();
    }

}
