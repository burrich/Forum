/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Nicolas
 */
@Entity
@DiscriminatorValue(value = "moderator")
public class Moderator extends User implements Serializable {

    public Moderator() {
    }

    public Moderator(String firstName, String lastName, String login, String passwd, List<Message> messages) {
        super(firstName, lastName, login, passwd, messages);
    }
    
}
