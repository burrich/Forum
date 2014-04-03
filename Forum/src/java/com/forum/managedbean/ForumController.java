/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Category;
import com.forum.service.CategoryService;
import com.forum.service.MessageService;
import com.forum.service.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@ViewScoped
public class ForumController implements Serializable {

    @EJB
    private CategoryService categoryService;
    
    @EJB
    private MessageService messageService;
    
    @EJB
    private UserService userService;
    
    private DataModel<Category> categoriesTableModel;
    
    /**
     * Creates a new instance of ForumController
     */
    public ForumController() {
    }
    
    public DataModel<Category> getCategoriesTableModel() throws IOException {
        final List<Category> workTimes = categoryService.getAllCategories();

        categoriesTableModel = new ListDataModel<Category>(workTimes);
        
        return categoriesTableModel;
    }

    public void setCategoriesTableModel(DataModel<Category> categoriesTableModel) {
        this.categoriesTableModel = categoriesTableModel;
    }
    
    public Long countMessages() {
        return messageService.countMessages();
    }
    
    public Long countUsers() {
        return userService.countUsers();
    }
}
