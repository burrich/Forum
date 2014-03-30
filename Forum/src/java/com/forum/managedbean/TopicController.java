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
public class TopicController implements Serializable {

    @EJB
    private TopicService topicService;
    
    @EJB
    private MessageService messageService;
    
    private Topic topic;
    private DataModel<Message> messagesTableModel;
    
    /**
     * Creates a new instance of TopicController
     */
    public TopicController() {
    }
    
    public String listMessages(Topic topic) {
        return "topic?faces-redirect=true&idTopic=" + topic.getId();
    }

    public String newMessage() {
        return "add_message?faces-redirect=true&idTopic=" + topic.getId();
    }

    public Topic getTopic() {
        if (topic == null) {
            topic = new Topic();
        }
        
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
    public void setTopic(int idTopic) {
        this.topic = topicService.getTopicById(idTopic);
    }
    
    public void setTopicById(String idTopic) {
        this.topic = topicService.getTopicById(Integer.parseInt(idTopic));
    }


    public DataModel<Message> getMessagesTableModel() throws IOException {
        final List<Message> messages = messageService.getMessagesByTopic(topic);

        messagesTableModel = new ListDataModel<Message>(messages);
        
        return messagesTableModel;
    }

    public void setMessagesTableModel(DataModel<Message> messagesTableModel) {
        this.messagesTableModel = messagesTableModel;
    }
    
}
