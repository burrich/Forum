/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Category;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@ViewScoped 
public class CategoryController implements Serializable {

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
    
    
}
