/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Category;
import com.forum.service.CategoryService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@ViewScoped
public class CategoryController {

    @EJB
    private CategoryService categoryService;
    
    private Category category;
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }
    
}
