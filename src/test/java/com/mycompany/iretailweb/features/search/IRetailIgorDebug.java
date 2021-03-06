
// Вот в этом файле мы пишем сами тесты 
//
// CamelCase names is 4 methods
// Underscore_names_is_4_page_elements
//
// методы называем действиеОбъектНазваниеОбъекта, напр. clickButtonLogin
// элементы страниц называем тип_название_элемента, напр. button_login 

package com.mycompany.iretailweb.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mycompany.iretailweb.steps.serenity.EndUserSteps;
import com.mycompany.iretailweb.utils.Cashier;
import com.mycompany.iretailweb.utils.Category;
import com.mycompany.iretailweb.utils.Const;
import com.mycompany.iretailweb.utils.DataGeneration;
import com.mycompany.iretailweb.utils.Device;
import com.mycompany.iretailweb.utils.Offer;
import com.mycompany.iretailweb.utils.TradePoint;
import com.mycompany.iretailweb.utils.User;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

//@DefaultUrl("https://dev2.iretail2.freematiq.com")
        
@RunWith(SerenityRunner.class)
public class IRetailIgorDebug {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    
    @Steps
    public EndUserSteps steps;
    
    @Before   
    public void before_execution() {
      
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //  webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
     //   webdriver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
    }
 
    @After
    public void after_execution(){
     webdriver.quit();
 }
    
   @Pending  @Test
    @Title("Authorization")
    public void authorization() throws InterruptedException {
        User user = new User();//Заменить на User.createNewUser() когда будут новые клиенты
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        assertTrue("Не перешел на главную страницу после авторизации", webdriver.getCurrentUrl().contains("/main"));
    }
    
    @Pending  @Test
    @Title("Create new company")
    public void create_new_company() throws InterruptedException {
        User user = new User();//Заменить на User.createNewUser() когда будут новые клиенты
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        String company_name = steps.createNewCompany();
        String script = "a=document.getElementsByClassName('txt');"
                + "return (a[a.length-1].getElementsByTagName('div')[0].innerHTML);"; 
        try {
            String getLastCompanyInList = (String)((JavascriptExecutor)webdriver).executeScript(script, webdriver.findElement(By.tagName("html")));
            System.out.println("Это компания которую мы создали " + company_name + "\n" + "Это последняя компания в списке " + getLastCompanyInList);

            assertTrue("Новая компания не появилась в списке",
                    getLastCompanyInList.equals(company_name));
        } 
        catch (Exception e) {
                System.err.println("Список компаний пуст");
        }
    }
    
   @Pending @Test
    @Title("Create new tradepoint")
    public void create_new_tradepoint() throws InterruptedException {
        User user = new User();//Заменить на User.createNewUser() когда будут новые клиенты
         user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        TradePoint tradePoint = steps.createNewTradePoint();
        String firstTradePoint= steps.getFirstTradePointName();
        System.out.println("Это торговая точка, которую мы создали " + tradePoint.getName() + "\n" + "Это первая торговая точка в списке " + firstTradePoint);
        assertTrue("Созданная торговая точка не появилась в списке", firstTradePoint.equals(tradePoint.getName()));
        }
    
    
    @Pending @Test 
    @Title("Create new category")
    public void create_new_category() throws InterruptedException, IOException {
        User user = new User();//Заменить на User.createNewUser() когда будут новые клиенты
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        Category category = steps.createNewCategory();//создаем новую категорию
        try {
             DataGeneration.TakeScreen(webdriver, "Категория "+System.currentTimeMillis());
            assertTrue("Не открылась страница созданной категории ", steps.getCategoryName().equals(category.getName()) & webdriver.getCurrentUrl().contains("category/update"));
           
        } catch (InterruptedException interruptedException) { 
            DataGeneration.TakeScreen(webdriver, "Категория "+System.currentTimeMillis());
        }
        //сошлись на том что нужно проверить название в поле название и одновременно с этим update в адр.строке 
    }
    
    
    @Pending @Test
    @Title("Create new offer")
    public void create_new_offer() throws InterruptedException {
        User user = new User();//Заменить на User.createNewUser() когда будут новые клиенты
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        Offer offer = steps.createNewOffer();//создаем новый товар
        try {
            steps.searchOfferByName(offer);
            webdriver.findElement(By.linkText(offer.getName())).click(); //пытаемся кликнуть на ссылку название товара
            assertTrue("Не открылась карточка созданного товара ", webdriver.getCurrentUrl().contains("/catalog/offers/update/"));
        } catch (Exception e) {
           Assert.fail("Созданный товар не отобразился в результатах поиска "+e.getMessage());
        }
        }
    
    @Pending @Test
    @Title("Create new device")
    public void create_new_device() throws InterruptedException {
        User user = new User();
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        steps.clickFirstTradePointOnList(); //нажимаем на первую торговую точку в списке
        steps.clickBtnAddDeviceOnTradePointTab(); //нажимаем кнопку добавить кассу на вкладке в торговой точке
        Device device = steps.createNewDevice();
        steps.searchDeviceByNameOnTradePointTab(device);
        try {
            webdriver.findElement(By.linkText(device.getName())).click();
        } catch (Exception e) {
            Assert.fail("Созданная касса не обнаружена в списке касс выбранной торговой точки");
    }
    }
    
    @Test
    @Title("Create new cashier")
    public void create_new_cashier() throws InterruptedException {
        User user = new User();
        user.setName(Const.userPhone);
        user.setPassword(Const.userPassword);
        steps.Authorization(user);
        steps.clickBtnAddCashierOnMainPage();
        Cashier cashier = steps.createNewCashier();
        steps.searchCashierByLastName(cashier,cashier.getLast_name());
        try {
            webdriver.findElement(By.linkText(cashier.getLast_name()+' '+cashier.getFirst_name())).click();
        } catch (Exception e) {
            Assert.fail("Созданный сотрудник не найден в списке сотрудников");
        }
    }
    }
    
    
