
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
import com.mycompany.iretailweb.utils.Category;
import com.mycompany.iretailweb.utils.Const;
import com.mycompany.iretailweb.utils.Offer;
import com.mycompany.iretailweb.utils.TradePoint;
import com.mycompany.iretailweb.utils.User;
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
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @After
    public void after_execution(){
     webdriver.quit();
 }
    
    @Pending @Test
    @Title("Authorization")
    public void authorization() throws InterruptedException {
        User user = new User();
        user.phone = Const.userPhone;
        user.password = Const.userPassword;
        steps.Authorization(user);
        Thread.sleep(2000);
        assertTrue("Не перешел на главную страницу после авторизации",
                webdriver.getCurrentUrl().contains("/main"));
    }
    
    @Pending @Test
    @Title("Create new company")
    public void create_new_company() throws InterruptedException {
        User user = new User();
        user.phone = Const.userPhone;
        user.password = Const.userPassword;
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
        User user = new User();
        user.phone = Const.userPhone;
        user.password = Const.userPassword;
        steps.Authorization(user);
        TradePoint tradePoint = steps.createNewTradePoint();
        String firstTradePoint= steps.getFirstTradePointName();
        System.out.println("Это торговая точка, которую мы создали " + tradePoint.name + "\n" + "Это первая торговая точка в списке " + firstTradePoint);
        assertTrue("Созданная торговая точка не появилась в списке", firstTradePoint.equals(tradePoint.name));
        }
    
    
    @Pending @Test
    @Title("Create new category")
    public void create_new_category() throws InterruptedException {
        User user = new User();
        user.phone = Const.userPhone;
        user.password = Const.userPassword;
        steps.Authorization(user);
        Category category = steps.createNewCategory();//создаем новую категорию
        System.out.println("Создана категория " + category.name);
        assertTrue("Не открылась страница созданной категории", steps.getCategoryName().contains(category.name)); //проверили открылась ли созданная категория
    }
    
    
    @Test
    @Title("Create new offer")
    public void create_new_offer() throws InterruptedException {
        User user = new User();
        user.phone = Const.userPhone;
        user.password = Const.userPassword;
        steps.Authorization(user);
        Offer offer = steps.createNewOffer();//создаем новый товар
        System.out.println("Создан товар " + offer.name);
        steps.searchOfferForName(offer);//поискали товар по названию
        try {
             webdriver.findElement(By.linkText(offer.name)).click(); //пытаемся кликнуть на ссылку название товара
        } catch (Exception e) {
           Assert.fail("Созданный товар не отобразился в результатах поиска "+e.getMessage());
        }
        assertTrue("Не открылась карточка созданного товара ", webdriver.getCurrentUrl().contains("/catalog/offers/update/"));
        }
        
    }
    