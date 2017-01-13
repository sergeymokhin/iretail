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
public class Category {

    public String name = "";
    
//в дальнейшем добавить родительскую категорию

    public static Category generateNewCategory() { //переименовать category
        Category сategory = new Category();
        сategory.name = DataGeneration.generateRandomString(10);
        return сategory;

    }
}
