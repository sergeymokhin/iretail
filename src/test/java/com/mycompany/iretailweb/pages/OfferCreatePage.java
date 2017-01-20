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
@DefaultUrl("/main/catalog/offers/create")

public class OfferCreatePage extends PageObject {

    //Находим поле Базовая цена
    @FindBy(xpath = "//input[@ng-model='vm.offer.base_price']")
    private WebElementFacade input_offer_base_price; //

    //Находим поле Название
    @FindBy(xpath = "//input[@ng-model='vm.offer.name']")
    private WebElementFacade input_offer_name;

    //Находим поле Артикул
    @FindBy(xpath = "//input[@ng-model='vm.offer.id_yml']")
    private WebElementFacade input_offer_artikul;

    //Находим поле Штрих-код
    @FindBy(xpath = "//input[@ng-model='vm.newTag']")
    private WebElementFacade input_offer_barcode;

    // Кнопка "Сгенерировать штрих-код" 
    @FindBy(xpath = "//button[@ng-click='vm.generateBarcode()']")
    private WebElementFacade btn_generate_barcode;

    // Кнопка "Сохранить товар"
    @FindBy(xpath = "//form[@name='vm.offerForm']/create-button/div/button")
    private WebElementFacade btn_save_offer;

    //* Кнопка "Ok" модального окна "Товар успешно создан"
    @FindBy(xpath = "//div[@class='jBox-Confirm-button jBox-Confirm-button-submit']")
    private WebElementFacade btn_ok;

    public void enterOfferBasePrice(Offer offer) {
        try {
            input_offer_base_price.type(offer.baseprice.toString());
        } catch (Exception e) {
            System.err.println("Не удалось ввести базовую цену товара " + e.getMessage());
        }

    }

    public void enterOfferName(Offer offer) {
        try {
            input_offer_name.type(offer.name);
        } catch (Exception e) {
            System.err.println("Не удалось ввести название товара " + e.getMessage());
        }

    }

    public void enterOfferArtikul(Offer offer) {
        try {
            input_offer_artikul.type(offer.artikul);
        } catch (Exception e) {
            System.err.println("Не удалось ввести артикул товара " + e.getMessage());
        }

    }

    public void enterOfferBarcode(Offer offer) {
        try {
            input_offer_barcode.type(offer.barcode);
        } catch (Exception e) {
            System.err.println("Не удалось ввести штрих код товара " + e.getMessage());
        }

    }

    public void clickBtnSaveOffer() {
        btn_save_offer.waitUntilVisible();
        btn_save_offer.click();

    }

    // * Жмем кнопку "Ок" в оповещении о создании товара.
    public void clickBtnOk() throws InterruptedException {
        btn_ok.waitUntilVisible();
        btn_ok.waitUntilClickable();
        btn_ok.click();
    }

}
