// Здесь различные шаги к тестам, а также последовательности шагов
package com.mycompany.iretailweb.steps.serenity;

import com.mycompany.iretailweb.pages.CategoryCreatePage;
import com.mycompany.iretailweb.pages.LoginPage;
import com.mycompany.iretailweb.pages.CreateProfilePage;
import com.mycompany.iretailweb.pages.MainPage;
import com.mycompany.iretailweb.pages.TradePointPage;
import com.mycompany.iretailweb.pages.TradePointCreatePage;
import com.mycompany.iretailweb.utils.CatalogCategory;
import com.mycompany.iretailweb.utils.TradePoint;
import com.mycompany.iretailweb.utils.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

public class EndUserSteps extends ScenarioSteps {

    LoginPage loginPage;
    MainPage mainPage;
    CreateProfilePage createProfilePage;
    TradePointCreatePage createTradePointPage;
    TradePointPage tradePointListPage;
    CategoryCreatePage createCategoryPage;

// Степы для авторизации
    @Step("Переходим на страницу авторизации")
    public void openLoginPage() {
        loginPage.open();
    }

    @Step("Переходим на страницу создания компании")
    public void openCreateProfilePage() {
        createProfilePage.open();
    }

    @Step("Переходим на главную страницу")
    public void openMainPage() {
        mainPage.open();
    }

    @Step("Вводим номер телефона пользователя в поле Ваш логин (e-mail или телефон)")
    private void enterPhone(User user) {
        loginPage.enterPhone(user);
    }

    @Step("Вводим пароль пользователя в поле Пароль")
    private void enterPassword(User user) {
        loginPage.enterPassword(user);
    }

    @Step("Нажимаем кнопку Войти")
    private void clickBtnLogin() {
        try {
            loginPage.ClickBtnLogin();
        } catch (Exception e) {
            Assert.fail("Нет кнопки Войти " + e.getMessage());
        }
    }

    @Step("Авторизация") // Общий метод на авторизацию
//    каждый метод желательно обернуть в трай кетч - DONE
    public void Authorization(User user) throws InterruptedException {
        try {
            openLoginPage();
        } catch (Exception e) {
            Assert.fail("Не перешел на страницу авторизации " + e.getMessage());
        }
        try {
            enterPhone(user);
        } catch (Exception e) {
            Assert.fail("Проблемы с полем ввода номера телефона " + e.getMessage());
        }
        try {
            enterPassword(user);
        } catch (Exception e) {
            Assert.fail("Проблемы с полем ввода пароля " + e.getMessage());
        }
        clickBtnLogin();
        Thread.sleep(3000);
// то, что мы авторизовались, мы проверяем в тесте IRetailTests - ("Authorization")
    }

// Степы для создания новой компании
    @Step("Вводим имя новой компании")
    private String enterCompanyName() {
        return createProfilePage.enterCompanyName();
    }

    @Step("Жмем кнопку Добавить компанию")
    private void clickBtnAddCompany() {
        createProfilePage.clickBtnAddCompany();
    }

    @Step("Подтверждаем что появилось модальное окно подтверждения создания компании")
    private boolean isModalAddNewCompanyPresent() {
        try {
            return createProfilePage.isModalAddNewCompanyPresent();
        } catch (Exception e) {
            Assert.fail("Нет модального окна подтверждения создания компани " + e.getMessage());
            return false;
        }
    }

    @Step("Жмем кнопку Да модального окна подтверждения создания компании")
    private void clickBtnYes() throws InterruptedException {
        createProfilePage.clickBtnYes();
    }

    @Step("Жмем кнопку Да модального окна Профиль успешно создан")
    private void clickBtnYesYes() throws InterruptedException {
        createProfilePage.clickBtnYesYes();
    }

    @Step("Создание новой компании") // общий степ для создания новой компании
    public String createNewCompany() throws InterruptedException {
        openCreateProfilePage();
        Thread.sleep(5000);
        String company_name = enterCompanyName();
        clickBtnAddCompany();
//        isModalAddNewCompanyPresent(); // можно и не подтверждать появление модалки
        clickBtnYes();
        clickBtnYesYes();
        return company_name;
    }

// Степы для создания новой торговой точки
    @Step("Переходим на страницу создания новой торговой точки")
    public void openCreateTradePointPage() {
        createTradePointPage.open();
    }

    // или:
    @Step("Нажимаем кнопку Добавить торговую точку") //на main странице
    public void clickBtnOnMainPageAddTradePoint() {
        mainPage.clickBtnAddTradePoint();
    }

    @Step("Заполняем поля торговой точки")
    public TradePoint fillTradePointData(TradePoint tradePoint) {
        createTradePointPage.enterTradePointName(tradePoint);
        createTradePointPage.selectTradePointCountry(tradePoint);
        createTradePointPage.enterTradePointCity(tradePoint);
        createTradePointPage.enterTradePointStreet(tradePoint);
        createTradePointPage.enterTradePointBuilding(tradePoint);
        return tradePoint;
    }

    @Step("Добавляем торговую точку и подтверждаем добавление")
    public void clickBtnSaveTradePoint() {
        try {
            createTradePointPage.clickBtnAddTradePoint();
            createTradePointPage.clickBtnYes();
            Thread.sleep(2000);
            createTradePointPage.clickBtnOk();
        } catch (Exception e) {
            Assert.fail("Не удалось подтвердить создание торговой точки " + e.getMessage());
        }
    }

    @Step("Получение названия первой торговой точки из списка") //степ получения названия первой торговой точки из списка
    public String getFirstTradePointName() throws InterruptedException {
        return tradePointListPage.getFirstTradePointName();
    }

    @Step("Создание новой торговой точки") // общий степ для создания новой торговой точки
    public TradePoint createNewTradePoint() throws InterruptedException {
        clickBtnOnMainPageAddTradePoint();
        TradePoint tradePoint = TradePoint.generateNewTradePoint();
        tradePoint = fillTradePointData(tradePoint);
        clickBtnSaveTradePoint();
        return tradePoint;
    }

    @Step("Нажимаем кнопку Создать категории") //на main странице
    public void clickBtnOnMainPageAddCategory() {
        mainPage.clickBtnAddCategory();
    }

    @Step("Заполняем поля категории")
    public void fillCategoryData(CatalogCategory catalogCategory) {
        createCategoryPage.enterCategoryName(catalogCategory);
    }

    @Step("Добавляем категорию и подтверждаем добавление")
    public void clickBtnSaveCategory() {
        try {
            createCategoryPage.clickBtnSaveCategory();
            createCategoryPage.clickBtnYes();
            Thread.sleep(2000);
            createCategoryPage.clickBtnOk();
        } catch (Exception e) {
            Assert.fail("Не удалось подтвердить создание категории " + e.getMessage());
        }
    }
//    @Step("Получаем все категории на странице")
//    public WebElementFacade createNewCategory() throws InterruptedException {
//    
//    }

    @Step("Создание новой категории каталога") //общий степ создания новой категории
    public CatalogCategory createNewCategory() throws InterruptedException {
        clickBtnOnMainPageAddCategory();
        CatalogCategory catalogCategory = CatalogCategory.generateNewCategory();
        fillCategoryData(catalogCategory);
        clickBtnSaveCategory();
        return catalogCategory;
    }

}

//TODO: Надо убидиться что мы создали торговую точку в конкретной компании
// Запулил, изменил эту строку и запушил снова.
