/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.service;

import com.forum.entity.Message;
import com.forum.entity.Topic;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nicolas
 */
@Stateless
public class MessageService {

    @PersistenceContext
    private EntityManager em;
    
    public List<Message> getMessagesByTopic(Topic topic) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);
        final Root<Message> messages = query.from(Message.class);
    
        query.where(
                criteriaBuilder.equal(
                    messages.get("topic").as(Topic.class), 
                    topic
        ));
        
        List<Message> getMessages = em.createQuery(query).getResultList();
        
        return getMessages;
    }
    
    public Message addMessage(Message message) {
        em.persist(message);
        return message;
    }
    
    public Long countMessages() {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        
        query.select(criteriaBuilder.count(query.from(Message.class)));
  
        return em.createQuery(query).getSingleResult();
    }
}
