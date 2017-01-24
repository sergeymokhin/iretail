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

    private String name = "";
    
//в дальнейшем добавить родительскую категорию

    public static Category generateNewCategory() { 
        Category сategory = new Category();
        сategory.name = DataGeneration.generateRandomString(10);
        return сategory;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
