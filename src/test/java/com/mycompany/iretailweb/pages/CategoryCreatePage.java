/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.CatalogCategory;
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

    // Кнопка "Сохранить"
    @FindBy(xpath = " //*[@translate='catalog.category.save']/parent::button")
    private WebElementFacade btn_save_category;

    @FindBy(xpath = "//ul[@dnd-list='vm.categoriesTree']/li")
    private WebElementFacade category_list;

    // Кнопка "Да" модального окна "Вы уверены, что хотите создать категорию"
    @FindBy(xpath = "//div[contains(@class, 'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes;

    // Кнопка "Ok" модального окна "Категория успешно создана"
    @FindBy(xpath = "//div[@class='jBox-Confirm-button jBox-Confirm-button-submit']")
    private WebElementFacade btn_ok;

    // Вводим название категории в поле "Название"
    public void enterCategoryName(CatalogCategory category) {
        try {
            input_category_name.type(category.name);
        } catch (Exception e) {
            System.err.println("Не удалось ввести название категории " + e.getMessage());
        }
    }

    // Жмем кнопку "Сохранить категорию"
    public void clickBtnSaveCategory() {
        btn_save_category.click();
    }

    public WebElementFacade categoryList() {
        return category_list;
    }
    
    
    // * Жмем кнопку "Да" модального окна подтверждения создания категории
    public void clickBtnYes() throws InterruptedException {
        btn_yes.click();
    }

// * Жмем кнопку "Ok" модального окна "Категория успешно создана"
    public void clickBtnOk() throws InterruptedException {
        Thread.sleep(2000);
        try {
            btn_ok.click();
        } catch (Exception e) {
            System.out.println("Не найдена кнопка Ok модального окна Категория успешно создана");
        }
        
    }    
}
