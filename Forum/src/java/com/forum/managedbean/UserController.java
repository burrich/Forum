/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.User;
import com.forum.service.UserService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@SessionScoped
public class UserController {

    @EJB
    private UserService userService;

    private User user;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }
    
    public String authenticateUser() {
        user = userService.authenticate(user.getLogin(), user.getPasswd());

        if(user == null) {
            return "login?faces-redirect=true&login=0";
        } else {
            return "index?faces-redirect=true";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    public int countUserMessages() {
        return user.getMessages().size();
    }

    public User getUser() {
        if(user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
