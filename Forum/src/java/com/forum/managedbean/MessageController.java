/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Message;
import com.forum.entity.Topic;
import com.forum.service.MessageService;
import com.forum.service.TopicService;
import com.forum.service.UserService;
import java.io.IOException;
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
public class MessageController implements Serializable {

    @EJB
    private MessageService messageService;
    
    @EJB
    private TopicService topicService;
    
    @EJB
    private UserService userService;
    
    private Message message;
    private Topic topic;
    
    /**
     * Creates a new instance of MessageController
     */
    public MessageController() {
    }

    public Message getMessage() {
        if (message == null) {
               message = new Message();
        }
        
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
    public void setTopicById(String idTopic) {
        this.topic = topicService.getTopicById(Integer.parseInt(idTopic));
    }
    
    public String addMessage() throws IOException {
        message.setTopic(topic);
        message.setUser(userService.getUserById(1));
   
        messageService.addMessage(message);
        
        return "topic?faces-redirect=true&idTopic=" + topic.getId();
    }
}
