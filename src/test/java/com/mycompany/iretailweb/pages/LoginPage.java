// Здесь элементы страницы авторизации (/login) и методы для работы с ними

package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 *
 * @author SergeyTest
 */

@DefaultUrl("/login")

public class LoginPage extends PageObject {
    
//*** Login Page elements ***
        
//* Поле для ввода логина *
    @FindBy(id = "phone")
    private WebElementFacade input_login;
    
//* Поле для ввода пароля*
    @FindBy(xpath = "//*[@type='password']")
    private WebElementFacade input_password;
    
//* Кнопка "Войти" *
    @FindBy(xpath = "//*[@type='submit']")
    private WebElementFacade btn_login;
   
    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;
    
//* Переключатель "Запомнить меня" *
//* Ссылка "Забыли пароль" *   
//* Ссылка "Создать аккаунт" *
    
//*** Methods ***
    
// * Вводим телефон пользователя в поле Ваш логин (e-mail или телефон) *  
    public void enterPhone(String phone) {
        input_login.waitForCondition();
       input_login.waitUntilClickable();
        input_login.type(phone);
    }

// * Вводим пароль пользователя в поле Пароль     
    public void enterPassword(String password) {
        input_password.waitForCondition();
       input_password.waitUntilClickable();
        input_password.type(password);
    }

// * Жмем кнопку Войти *    
    public void ClickBtnLogin() {
        btn_login.waitForCondition();
        btn_login.waitUntilClickable();
        btn_login.click();
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
