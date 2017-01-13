/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

/**
 *
 * @author igorg
 */
public class CatalogCategory {

    public String name = "";
    
//в дальнейшем добавить родительскую категорию

    public static CatalogCategory generateNewCategory() { //переименовать category
        CatalogCategory catalogCategory = new CatalogCategory();
        catalogCategory.name = DataGeneration.generateRandomString(10);
        return catalogCategory;

    }
}
