// Здесь различные шаги к тестам, а также последовательности шагов
package com.mycompany.iretailweb.steps.serenity;

import com.mycompany.iretailweb.pages.CashierCreatePage;
import com.mycompany.iretailweb.pages.CashierPage;
import com.mycompany.iretailweb.pages.CategoryCreatePage;
import com.mycompany.iretailweb.pages.LoginPage;
import com.mycompany.iretailweb.pages.CreateProfilePage;
import com.mycompany.iretailweb.pages.DeviceCreatePage;
import com.mycompany.iretailweb.pages.MainPage;
import com.mycompany.iretailweb.pages.OfferCreatePage;
import com.mycompany.iretailweb.pages.OffersPage;
import com.mycompany.iretailweb.pages.TradePointPage;
import com.mycompany.iretailweb.pages.TradePointCreatePage;
import com.mycompany.iretailweb.pages.TradePointUpdatePage;
import com.mycompany.iretailweb.utils.Cashier;
import com.mycompany.iretailweb.utils.Category;
import com.mycompany.iretailweb.utils.Device;
import com.mycompany.iretailweb.utils.Offer;
import com.mycompany.iretailweb.utils.TradePoint;
import com.mycompany.iretailweb.utils.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EndUserSteps extends ScenarioSteps {

LoginPage loginPage;
MainPage mainPage;
CreateProfilePage createProfilePage;
TradePointCreatePage createTradePointPage;
TradePointPage tradePointListPage;
CategoryCreatePage createCategoryPage;
OfferCreatePage createOfferPage;
OffersPage offerListPage;
TradePointUpdatePage tradePointUpdatePage;
DeviceCreatePage createDevicePage;
CashierCreatePage createCashierPage;
CashierPage cashierPage;

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
@Step("Переходим на страницу торговых точек")
public void openTradePointPage() {
tradePointListPage.open();
}

@Step("Вводим номер телефона {0} в поле Ваш логин (e-mail или телефон)")
public void enterPhone(String phone) {
loginPage.enterPhone(phone);
}

@Step("Вводим пароль {0} в поле Пароль")
public void enterPassword(String password) {
loginPage.enterPassword(password);
}

@Step("Нажимаем кнопку Войти")
public void clickBtnLogin() {
try {
loginPage.ClickBtnLogin();
} catch (Exception e) {
Assert.fail("Нет кнопки Войти " + e.getMessage());
}
}

@Step("Авторизация") // Общий метод на авторизацию
// каждый метод желательно обернуть в трай кетч - DONE
public void Authorization(User user) throws InterruptedException {
    
try {
    openLoginPage();
    loginPage.waitForLoad();
} catch (Exception e) {
    Assert.fail("Не перешел на страницу авторизации " + e.getMessage());
}
LoginAs(user.getPhone(), user.getPassword());
clickBtnLogin();
mainPage.waitForLoad();
// то, что мы авторизовались, мы проверяем в тесте IRetailTests - ("Authorization")
}

@Step("Авторизуюсь под {0}/{1}") // Общий метод на авторизацию
public void LoginAs(String phone,String password) {
try {
    enterPhone(phone);
} catch (Exception e) {
    Assert.fail("Проблемы с полем ввода номера телефона " + e.getMessage());
}
try {
enterPassword(password);
} catch (Exception e) {
Assert.fail("Проблемы с полем ввода пароля " + e.getMessage());
}
}

// Степы для создания новой компании
@Step("Вводим имя новой компании")
public String enterCompanyName() {
return createProfilePage.enterCompanyName();
}

@Step("Жмем кнопку Добавить компанию")
public void clickBtnAddCompany() {
createProfilePage.clickBtnAddCompany();
}

@Step("Подтверждаем что появилось модальное окно подтверждения создания компании")
public boolean isModalAddNewCompanyPresent() {
try {
return createProfilePage.isModalAddNewCompanyPresent();
} catch (Exception e) {
Assert.fail("Нет модального окна подтверждения создания компани " + e.getMessage());
return false;
}
}

@Step("Жмем кнопку Да модального окна подтверждения создания компании")
public void clickBtnYes() throws InterruptedException {
createProfilePage.clickBtnYes();
}

@Step("Жмем кнопку Да модального окна Профиль успешно создан")
public void clickBtnYesYes() throws InterruptedException {
createProfilePage.clickBtnYesYes();
}

@Step("Создание новой компании") // общий степ для создания новой компании
public String createNewCompany() throws InterruptedException {
mainPage.waitForLoad();
openCreateProfilePage();
String company_name = enterCompanyName();
clickBtnAddCompany();
clickBtnYes();
clickBtnYesYes();
createProfilePage.waitForLoad();
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

@Step("Нажимаем кнопку Добавить сотрудников") //на main странице
public void clickBtnAddCashierOnMainPage() {
mainPage.clickBtnAddCashier();
}

@Step("Выбираем таб Кассы") //в торговой точке
public void clickTabDeviceOnTradePoint() throws InterruptedException {
    try {
        tradePointUpdatePage.clickDeviceTab();
    } catch (Exception e) {
        Assert.fail("Не перешел в таб кассы торговой точки " + e.getMessage());
    }

}

@Step("Нажимаем кнопку Добавить кассу") //в торговой точке
public void clickBtnAddDeviceOnTradePoint() throws InterruptedException {
    try {
        tradePointUpdatePage.clickBtnAddDevice();
    } catch (Exception e) {
         Assert.fail("Не нажалась кнопка добавить кассу " + e.getMessage());
    }

}

@Step("Нажимаем кнопку на вкладке касс торговой точки") //в торговой точке
public void clickBtnAddDeviceOnTradePointTab() throws InterruptedException {
clickTabDeviceOnTradePoint();
clickBtnAddDeviceOnTradePoint();

}

@Step("Заполняем поля торговой точки, название {1}")
public TradePoint fillTradePointData(TradePoint tradePoint, String reportName) {
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
tradePoint = fillTradePointData(tradePoint, tradePoint.getName());
clickBtnSaveTradePoint();
return tradePoint;
}

@Step("Нажимаем кнопку Создать категории") //на main странице
public void clickBtnAddCategoryOnMainPage() {
mainPage.clickBtnAddCategory();
}

@Step("Заполняем поля категории с названием {1}")
public Category fillCategoryData(Category category, String reportName) {
createCategoryPage.enterCategoryName(category);
return category;
}

@Step("Нажимаем на кнопку сохранить и все окна подтверждения")
public void clickBtnSaveCategory() {
try {
createCategoryPage.clickBtnSaveCategory();
createCategoryPage.waitForLoad();
createCategoryPage.clickBtnYes();
createCategoryPage.clickBtnOk();
} catch (InterruptedException e) {
Assert.fail("Не удалось сохранить категорию " + e.getMessage());
}
}

@Step("Получаем название категории открытой на странице")
public String getCategoryName() throws InterruptedException {
return createCategoryPage.getCategoryName();

}

@Step("Создание новой категории каталога") //общий степ создания новой категории
public Category createNewCategory() throws InterruptedException {
clickBtnAddCategoryOnMainPage();
Category category = Category.generateNewCategory(); 
category = fillCategoryData(category,category.getName()); 
clickBtnSaveCategory();
return category;
}

@Step("Нажимаем кнопку Добавить товары") //на main странице
public void clickBtnAddOfferOnMainPage() {
        try {
            mainPage.clickBtnAddOffer();
        } catch (Exception e) {
            Assert.fail("Не удалось нажать кнопку добавить товар на главной странице " + e.getMessage());
        }

}

    @Step("Заполняем поля товара с названием {1}")
    public Offer fillOfferData(Offer offer, String reportName) {
        try {
            createOfferPage.enterOfferName(offer);
            createOfferPage.enterOfferArticle(offer);
            createOfferPage.enterOfferBasePrice(offer);
        } catch (Exception e) {
            Assert.fail("Не удалось заполнить поля товара " + e.getMessage());
        }
        return offer;
    }

@Step("Сохраняем товар и нажимаем ок")
public void clickBtnSaveOffer() {
try {
createOfferPage.clickBtnSaveOffer();
createOfferPage.clickBtnOk();
} catch (InterruptedException e) {
Assert.fail("Не удалось сохранить товар " + e.getMessage());
}
}
@Step("Поиск товара по названию")
public void searchOfferByName(Offer offer) {
    try {
     offerListPage.enterOfferName(offer);
     offerListPage.clickBtnSearch();
    } catch (Exception e) {
        Assert.fail("Не удалось воспользоваться поиском товара " + e.getMessage());
    }

}

    @Step("Поиск кассы по названию")
    public void searchDeviceByNameOnTradePointTab(Device device) throws InterruptedException {
        try {
            tradePointUpdatePage.clickDeviceTab();
            tradePointUpdatePage.enterDeviceNameInFilter(device); //On используем для кликов и т.п. Если что-то вводишь замени на In
            tradePointUpdatePage.clickBtnSearch();
        } catch (Exception e) {
            Assert.fail("Не удалось воспользоваться поиском кассы в торговой точке " + e.getMessage());
        }

}

    @Step("Переход в первую торговую точку в списке")
    public void clickFirstTradePointOnList() throws InterruptedException {
        try {
            mainPage.waitForLoad();
            tradePointListPage.open();
            tradePointListPage.clickFirstTradePointName();
        } catch (Exception e) {
            Assert.fail("Не удалось перейти в первую торговую точку в списке " + e.getMessage());
        }

}

@Step("Создание нового товара") //общий степ создания товара
public Offer createNewOffer() throws InterruptedException {
mainPage.waitForLoad();
clickBtnAddOfferOnMainPage();
Offer offer = Offer.generateNewOffer(); //парни говорят что если статический метод возвращает экземпляр класса с заполненными значениями это нормас
offer = fillOfferData(offer,offer.getName());
clickBtnSaveOffer();
return offer;
}
@Step("Заполнение полей кассы с названием {1}")
public Device fillDeviceData(Device device,String reportName) throws InterruptedException {
    try {
        createDevicePage.enterDeviceName(device);
    } catch (Exception e) {
        Assert.fail("Не удалось заполнить поля кассы " + e.getMessage());
    }
    return device;
}

@Step("Создание новой кассы")
public Device createNewDevice() throws InterruptedException {
    Device device = Device.generateNewDevice();
    try {
        fillDeviceData(device, device.getName());
        createDevicePage.clickBtnSaveDevice();
        createDevicePage.waitForLoad();
    } catch (Exception e) {
        Assert.fail("Не удалось сохранить кассу " + device.getName()+" "+ e.getMessage());
    }
return device;
}

    @Step("Создание нового сотрудника")
    public Cashier createNewCashier() throws InterruptedException {
        Cashier cashier = Cashier.createNewCashier();
        try {
            fillNewCashier(cashier,cashier.getLast_name());
            saveNewCashier();
        } catch (Exception e) {
            Assert.fail("Не удалось создать сотрудника");
        }
        return cashier; 
    }

    @Step("Заполнение данных нового сотрудника с фамилией {1}")
    public Cashier fillNewCashier(Cashier cashier,String reportName) throws InterruptedException {
        try { 
            createCashierPage.enterCashierLastName(cashier);
            createCashierPage.enterCashierFirstName(cashier);
            createCashierPage.clickCashierWorksInAllChannels();
            createCashierPage.enterCashierEmail(cashier);
            createCashierPage.enterCashierPhone(cashier);
            createCashierPage.clickBtnGeneratePin();
        } catch (Exception e) {
            //!!! давай по всем важным кэтчам будем привыкать скринить экран. или уже сделать общий универсальный метод заваливания
            Assert.fail("Не удалось заполнить данные нового сотрудника");
        }
        return cashier;
    }

    @Step("Сохранение нового сотрудника")
    public void saveNewCashier() throws InterruptedException {
        try {
            createCashierPage.clickBtnAddСashier();
            createCashierPage.clickBtnYes();
            createCashierPage.clickBtnOk();
        } catch (Exception e) {
            Assert.fail("Не удалось сохранить сотрудника");
        }
    }
    
    @Step("Поиск сотрудника по фамилии {1}")
    public void searchCashierByLastName(Cashier cashier,String reportName) throws InterruptedException {
        try {
            cashierPage.enterCashierName(cashier);
            cashierPage.clickBtnSearch();
        } catch (Exception e) {
            Assert.fail("Не удалось выполнить поиск сотрудника");
        }
    }


}
