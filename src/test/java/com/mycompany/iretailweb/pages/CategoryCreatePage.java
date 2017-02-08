/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.Category;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author igorg
 */
@DefaultUrl("/main/catalog/category/create")
public class CategoryCreatePage extends PageObject {

//*** Page elements ***
    //Поле "Название" обязательное для заполнения
    @FindBy(xpath = " //input[@ng-model='vm.category.title']")
    private WebElementFacade input_category_name;

    //Заголовок блока в котором отображается название категории
    @FindBy(xpath = "//h2[contains(@translate,'Категория')]")
    private WebElementFacade category_header;

    // Кнопка "Сохранить"
    @FindBy(xpath = " //*[@translate='catalog.category.save']/parent::button")
    private WebElementFacade btn_save_category;

    // Кнопка "Да" модального окна "Вы уверены, что хотите создать категорию"
    @FindBy(xpath = "//div[contains(@class, 'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes;

    // Кнопка "Ok" модального окна "Категория успешно создана"
    @FindBy(xpath = "//div[@class='jBox-Confirm-button jBox-Confirm-button-submit']")
    private WebElementFacade btn_ok;
    
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;
    

    // Вводим название категории в поле "Название"
    public void enterCategoryName(Category category) {
        try {
            loader.waitUntilNotVisible();
            input_category_name.type(category.getName());
        } catch (Exception e) {
            System.err.println("Не удалось ввести название категории " + e.getMessage());
        }
    }

    public String getCategoryName() {
        try {
            loader.waitUntilNotVisible();
          return  input_category_name.getTextValue() ; // беру заголовок блока с названием категории
        } catch (Exception e) {
            System.err.println("Не удалось получить название категории " + e.getMessage());
            return null;
        }
    }

    // Жмем кнопку "Сохранить категорию"
    public void clickBtnSaveCategory() {
        try {
            loader.waitUntilNotVisible();
         //   btn_save_category.waitUntilClickable();
            btn_save_category.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка сохранения категории");
        }

    }

    // * Жмем кнопку "Да" модального окна подтверждения создания категории
    public void clickBtnYes() throws InterruptedException {
        try {
            loader.waitUntilNotVisible();
          //  btn_yes.waitUntilClickable();
            btn_yes.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка Да окна подтверждения создания категории");
        }
    }

// * Жмем кнопку "Ok" модального окна "Категория успешно создана"
    public void clickBtnOk() throws InterruptedException {
        try {
            loader.waitUntilNotVisible();
       //     btn_ok.waitUntilClickable();
            btn_ok.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка Ok модального окна Категория успешно создана");
        }

    }
}
