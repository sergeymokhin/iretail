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
    public void enterPhone(User user) {
        loader.waitUntilNotVisible();
        input_login.type(user.getPhone());
    }

// * Вводим пароль пользователя в поле Пароль     
    public void enterPassword(User user) {
        loader.waitUntilNotVisible();
        input_password.type(user.getPassword());
    }

// * Жмем кнопку Войти *    
    public void ClickBtnLogin() {
        loader.waitUntilNotVisible();
        btn_login.click();
    }
    
    
    
}
