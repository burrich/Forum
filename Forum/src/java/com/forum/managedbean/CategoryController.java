/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Category;
import com.forum.service.CategoryService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@ViewScoped 
public class CategoryController implements Serializable {

    @EJB
    private CategoryService categoryService;
    private Category category;
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }
    
    public Category getCategory() {
        if(category == null) {
            category = new Category();
        }
        
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void renameCategory() {
        categoryService.renameCategory(category);
    }
    
    public void addCategory() {
        categoryService.addCategory(category);
    }
    
    public void deleteCategory(Category go) {
        categoryService.deleteCategory(go);
    }
}
