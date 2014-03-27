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
        // Try to authenticate the user whose actually binded to the view
        user = userService.authenticate(user.getLogin(), user.getPasswd());

        // faces-redirect=true means the user will be TRULLY redirected (not only "forwarded" so
        // the URL in his browser will change)
        if(user == null) {
            // The user is null so the provided creditentials are invalids
            return "login?faces-redirect=true&login=0";
        } else {
            return "test?faces-redirect=true&login=1";
        }
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
