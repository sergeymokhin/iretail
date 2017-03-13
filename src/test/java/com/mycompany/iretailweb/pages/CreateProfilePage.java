// Здесь элементы страницы создания компании(/main/create-profile) и методы для работы с ними
package com.mycompany.iretailweb.pages;

import com.mycompany.iretailweb.utils.DataGeneration;
import com.mycompany.iretailweb.utils.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.scheduling.ThucydidesFluentWait;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author SergeyTest
 */
@DefaultUrl("/main/create-profile")

public class CreateProfilePage extends PageObject {

//*** Page elements ***
//* Поле "Название компании" *
    @FindBy(xpath = "//*[@translate='profileCompany.settings.name']/parent::*/input")
    private WebElementFacade input_company_name;

//* Кнопка "Добавить компанию" *
    @FindBy(xpath = "//span[@translate='profileCreate.addCompany']/parent::button")
    private WebElementFacade btn_add_company;

//* Модальное окно подтверждения создания компании 
//  (появляется после нажатия на кнопку "Добавить компанию") *  
    @FindBy(xpath = "//div[@class='jBox-container']")
    private WebElementFacade modal_add_new_company;

//* Кнопка "Да" модального окна подтверждения создания компании
    @FindBy(xpath = "//div[contains(@class, 'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes;

////* Модальное окно "Профиль успешно создан" уведомляющее об успешном создании компании 
////  (появляется после нажатия на кнопку "Да" модального окна подтверждения создания компаниии) *  
//    @FindBy (xpath = "//div[@class='jBox-Confirm-footer']")
//    private WebElementFacade modal_inform_about_new_company_creation;
//* Кнопка "Да" модального окна "Профиль успешно создан"
    @FindBy(xpath = "//div[contains(@style,'display: block')]//div[contains(@class,'jBox-Confirm-button-submit')]")
    private WebElementFacade btn_yes_yes;

    @FindBy(xpath = "//div[@ng-if='vm.showLoader()']")// пытаемся отловить лоадер 
    private WebElementFacade loader;

//*** Methods ***
// * Вводим название компании в поле "Название компании" *  
    public String enterCompanyName() {
        waitForLoad();
        input_company_name.waitForCondition();
        String company_name = DataGeneration.generateRandomString(8);
        input_company_name.type(company_name);
        return company_name;
    }

// * Жмем кнопку "Добавить компанию" *    
    public void clickBtnAddCompany() {
        try {
            btn_add_company.waitForCondition();
            btn_add_company.waitUntilClickable();
            btn_add_company.click();
        } catch (Exception e) {
            System.out.println("Не удалось нажать кнопку сохранения компании");
        }

    }

    @Override
    public ThucydidesFluentWait<WebDriver> waitForWithRefresh() {
        return super.waitForWithRefresh(); //To change body of generated methods, choose Tools | Templates.
    }

// * Подтверждаем, что модальное окно подтверждения создания компании появилось
    public boolean isModalAddNewCompanyPresent() {
        waitForLoad();
        return modal_add_new_company.isDisplayed();
    }

// * Жмем кнопку "Да" модального окна подтверждения создания компании
    public void clickBtnYes() throws InterruptedException {
        try {
            btn_yes.waitUntilClickable();
            btn_yes.click();
        } catch (Exception e) {
            System.out.println("Не удалось нажать кнопку да модального окна подтверждения создания компании");
        }

    }

// * Жмем кнопку "Да" модального окна "Профиль успешно создан"
    public void clickBtnYesYes() throws InterruptedException {
        try {
            btn_yes_yes.waitUntilClickable();
            btn_yes_yes.click();
        } catch (Exception e) {
            System.out.println("Не удалось нажать кнопку ок модального окна Профиль успешно создан");
        }

    }

    public void waitForLoad() {
        try {
            loader.waitUntilVisible();
            loader.waitUntilNotVisible();
        } catch (Exception e) {
            System.err.println("Не отображается лоадер ещё(уже)");
        }
    }

}
